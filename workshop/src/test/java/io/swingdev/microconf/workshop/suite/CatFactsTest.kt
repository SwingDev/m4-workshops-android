package io.swingdev.microconf.workshop.suite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins
import io.swingdev.microconf.workshop.R
import io.swingdev.microconf.workshop.TestApplication
import io.swingdev.microconf.workshop.presentation.main.CatFactListAdapter
import io.swingdev.microconf.workshop.presentation.main.CatFactsActivity
import io.swingdev.microconf.workshop.utils.TestObjects
import org.junit.Assert
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
            Assert.assertSame(TestObjects.savedFacts, it.getAdapter().data)
        }
    }

    @Test
    fun `Should update new cat facts`() {
        scenario.onActivity {
            it.onRefreshData()

            Assert.assertSame(TestObjects.newFacts, it.getAdapter().data)
        }
    }

    private fun CatFactsActivity.getAdapter(): CatFactListAdapter =
        findViewById<RecyclerView>(R.id.factList).adapter as CatFactListAdapter
}