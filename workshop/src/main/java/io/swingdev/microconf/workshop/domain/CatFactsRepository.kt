package io.swingdev.microconf.workshop.domain

import io.swingdev.microconf.workshop.domain.db.CatFactsDao
import io.swingdev.microconf.workshop.domain.network.ApiClient

// TODO: Inject constructor
class CatFactsRepository constructor(
    private val apiClient: ApiClient,
    private val catFactsDao: CatFactsDao
) {

    // TODO: Invoke DAO and return Observable
    fun fetchCatFacts() = Unit

    // TODO: Invoke API Client and return Observable
    fun updateCatFacts() = Unit

    companion object {
        private const val DEFAULT_AMOUNT = 20
    }
}