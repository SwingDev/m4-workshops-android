package io.swingdev.microconf.mvvm.domain.network

import io.swingdev.microconf.mvvm.domain.model.CatFact
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/facts/random")
    fun getCatFacts(@Query("amount") amount: Int): Call<List<CatFact>>
}