package io.swingdev.microconf.mvc.presentation.main

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.swingdev.microconf.mvc.MainApplication
import io.swingdev.microconf.mvc.R
import io.swingdev.microconf.mvc.domain.db.CatFactsDao
import io.swingdev.microconf.mvc.domain.model.CatFact
import io.swingdev.microconf.mvc.domain.network.ApiClient
import kotlinx.android.synthetic.main.activity_cat_facts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CatFactsActivity : AppCompatActivity() {

    @Inject
    lateinit var catFactsDao: CatFactsDao

    @Inject
    lateinit var apiClient: ApiClient

    private val adapter by lazy {
        CatFactListAdapter()
    }

    private val savedFacts by lazy {
        catFactsDao.getAll()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_facts)

        (application as MainApplication).injector.inject(this)

        factList.adapter = adapter

        savedFacts.observe(this, Observer {
            if (it.isNotEmpty()) {
                swipeLayout.isRefreshing = false
                adapter.data = it
            }
        })

        swipeLayout.setOnRefreshListener {
            ActionTask {
                apiClient.getCatFacts(DEFAULT_AMOUNT)
                    .enqueue(object : Callback<List<CatFact>> {
                        override fun onResponse(
                            call: Call<List<CatFact>>,
                            response: Response<List<CatFact>>
                        ) {
                            ActionTask {
                                catFactsDao.clearAll()
                                response.body()?.let(catFactsDao::saveAll)
                            }.execute()
                        }

                        override fun onFailure(
                            call: Call<List<CatFact>>,
                            t: Throwable
                        ) = Unit
                    })
            }.execute()
        }
    }

    companion object {
        private const val DEFAULT_AMOUNT = 20
    }
}

private class ActionTask(
    private val action: () -> Unit
) : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg params: Void?): Void? {
        action()
        return null
    }
}