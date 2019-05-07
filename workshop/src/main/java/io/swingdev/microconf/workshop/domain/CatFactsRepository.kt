package io.swingdev.microconf.workshop.domain

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.swingdev.microconf.workshop.domain.db.CatFactsDao
import io.swingdev.microconf.workshop.domain.model.CatFact
import io.swingdev.microconf.workshop.domain.network.ApiClient
import javax.inject.Inject

class CatFactsRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val catFactsDao: CatFactsDao
) {

    fun fetchCatFacts(): Observable<List<CatFact>> =
        catFactsDao.getAll()
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .defaultIfEmpty(emptyList())
            .toObservable()
            .flatMap { savedFacts ->
                when {
                    savedFacts.isEmpty() -> updateCatFacts()
                    else -> Observable.just(savedFacts)
                }
            }

    fun updateCatFacts(): Observable<List<CatFact>> =
        apiClient.getCatFacts(DEFAULT_AMOUNT)
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
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