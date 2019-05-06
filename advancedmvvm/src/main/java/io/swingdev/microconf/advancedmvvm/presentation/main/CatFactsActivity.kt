package io.swingdev.microconf.advancedmvvm.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import io.swingdev.microconf.advancedmvvm.R
import io.swingdev.microconf.advancedmvvm.databinding.ActivityCatFactsBinding
import kotlinx.android.synthetic.main.activity_cat_facts.*
import javax.inject.Inject

class CatFactsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CatFactsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[CatFactsViewModel::class.java]
    }

    private val adapter by lazy { CatFactListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        DataBindingUtil.setContentView<ActivityCatFactsBinding>(
            this, R.layout.activity_cat_facts
        ).also {
            it.lifecycleOwner = this
            it.adapter = adapter
        }
        viewModel.catFacts.observe(this, Observer {
            if (it.isNotEmpty()) {
                swipeLayout.isRefreshing = false
                adapter.data = it
            }
        })
        viewModel.errorHandler.observe(this, Observer {
            swipeLayout.isRefreshing = false
            it.printStackTrace()
        })
        swipeLayout.setOnRefreshListener {
            onRefreshData()
        }
    }

    fun onRefreshData() {
        viewModel.updateData()
    }
}
