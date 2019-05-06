package io.swingdev.microconf.mvvm.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.swingdev.microconf.mvvm.MainApplication
import io.swingdev.microconf.mvvm.R
import io.swingdev.microconf.mvvm.databinding.ActivityCatFactsBinding
import kotlinx.android.synthetic.main.activity_cat_facts.*
import javax.inject.Inject

class CatFactsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: CatFactsViewModel.Factory

    private val viewModel: CatFactsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[CatFactsViewModel::class.java]
    }

    private val adapter by lazy { CatFactListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MainApplication).injector.inject(this)

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
        swipeLayout.setOnRefreshListener {
            viewModel.updateData()
        }
    }
}
