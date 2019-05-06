package io.swingdev.microconf.advancedmvvm.domain.network

import io.swingdev.microconf.advancedmvvm.domain.model.CatFact
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/facts/random")
    fun getCatFacts(@Query("amount") amount: Int): Maybe<List<CatFact>>
}