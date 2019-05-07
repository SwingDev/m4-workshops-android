package io.swingdev.microconf.workshop.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import io.swingdev.microconf.workshop.R
import io.swingdev.microconf.workshop.databinding.ActivityCatFactsBinding
import kotlinx.android.synthetic.main.activity_cat_facts.*

class CatFactsActivity : AppCompatActivity() {

    // TODO: Inject factory
    lateinit var factory: ViewModelProvider.Factory

    // TODO: Provide ViewModel instance using factory
    private lateinit var viewModel: CatFactsViewModel

    private val adapter by lazy {
        CatFactListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Inject Activity

        DataBindingUtil.setContentView<ActivityCatFactsBinding>(
            this, R.layout.activity_cat_facts
        ).also {
            it.lifecycleOwner = this
            it.adapter = adapter
        }

        // TODO: Observe CatFacts list

        // TODO: Observe Error Handler

        swipeLayout.setOnRefreshListener {
            onRefreshData()
        }
    }

    fun onRefreshData() {
        viewModel.updateData()
    }
}
