package io.swingdev.microconf.workshop.suite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins
import io.swingdev.microconf.workshop.R
import io.swingdev.microconf.workshop.presentation.main.CatFactListAdapter
import io.swingdev.microconf.workshop.presentation.main.CatFactsActivity
import org.junit.Before
import org.junit.Test

// TODO: Annotate test passing application class
class CatFactsTest {
    private lateinit var scenario: ActivityScenario<CatFactsActivity>

    @Before
    fun setUp() {
        RxJavaPlugins.setIoSchedulerHandler { AndroidSchedulers.mainThread() }

        // TODO: Launch CatFacts Activity
    }

    @Test
    fun `Should load saved cat facts`() {
        // TODO: Assert saved CatFact list is same as actual adapter's data
    }

    @Test
    fun `Should update new cat facts`() {
        // TODO: Load data
        // TODO: Assert updated CatFact list is same as actual adapter's data
    }

    private fun CatFactsActivity.getAdapter(): CatFactListAdapter =
        findViewById<RecyclerView>(R.id.factList).adapter as CatFactListAdapter
}