package io.swingdev.microconf.mvvm.domain

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import io.swingdev.microconf.mvvm.domain.db.CatFactsDao
import io.swingdev.microconf.mvvm.domain.model.CatFact
import io.swingdev.microconf.mvvm.domain.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CatFactsRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val catFactsDao: CatFactsDao
) {

    fun fetchCatFacts(): LiveData<List<CatFact>> = catFactsDao.getAll()

    fun updateCatFacts() {
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