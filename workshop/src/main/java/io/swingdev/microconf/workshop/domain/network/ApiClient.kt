package io.swingdev.microconf.workshop.domain.network

import io.reactivex.Maybe
import io.swingdev.microconf.workshop.domain.model.CatFact
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/facts/random")
    fun getCatFacts(@Query("amount") amount: Int): Maybe<List<CatFact>>
}