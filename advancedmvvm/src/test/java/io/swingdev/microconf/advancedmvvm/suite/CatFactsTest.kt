package io.swingdev.microconf.advancedmvvm.suite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins
import io.swingdev.microconf.advancedmvvm.R
import io.swingdev.microconf.advancedmvvm.TestApplication
import io.swingdev.microconf.advancedmvvm.presentation.main.CatFactListAdapter
import io.swingdev.microconf.advancedmvvm.presentation.main.CatFactsActivity
import io.swingdev.microconf.advancedmvvm.utils.TestObjects
import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
class CatFactsTest {
    private lateinit var scenario: ActivityScenario<CatFactsActivity>

    @Before
    fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { AndroidSchedulers.mainThread() }

        scenario = ActivityScenario.launch(CatFactsActivity::class.java)
    }

    @Test
    fun `Should load saved cat facts`() {
        scenario.onActivity {
            assertSame(TestObjects.savedFacts, it.getAdapter().data)
        }
    }

    @Test
    fun `Should update new cat facts`() {
        scenario.onActivity {
            it.onRefreshData()

            assertSame(TestObjects.newFacts, it.getAdapter().data)
        }
    }

    private fun CatFactsActivity.getAdapter(): CatFactListAdapter =
        findViewById<RecyclerView>(R.id.factList).adapter as CatFactListAdapter
}