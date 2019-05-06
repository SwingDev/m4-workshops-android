package io.swingdev.microconf.mvc.domain.network

import io.swingdev.microconf.mvc.domain.model.CatFact
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/facts/random")
    fun getCatFacts(@Query("amount") amount: Int): Call<List<CatFact>>
}