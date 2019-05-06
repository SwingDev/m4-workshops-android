package io.swingdev.microconf.advancedmvvm.domain

import io.swingdev.microconf.advancedmvvm.domain.db.CatFactsDao
import io.swingdev.microconf.advancedmvvm.domain.model.CatFact
import io.swingdev.microconf.advancedmvvm.domain.network.ApiClient
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CatFactsRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val catFactsDao: CatFactsDao
) {

    fun fetchCatFacts(): Observable<List<CatFact>> =
        catFactsDao.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .defaultIfEmpty(emptyList())
            .toObservable()
            .flatMap { savedFacts ->
                when {
                    savedFacts.isEmpty() -> updateFacts()
                    else -> Observable.just(savedFacts)
                }
            }

    fun updateFacts(): Observable<List<CatFact>> =
        apiClient.getCatFacts(DEFAULT_AMOUNT)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .toObservable()
            .map { receivedFacts ->
                catFactsDao.clearAll()
                catFactsDao.saveAll(receivedFacts)
                receivedFacts
            }

    companion object {
        private const val DEFAULT_AMOUNT = 20
    }
}