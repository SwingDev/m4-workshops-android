package io.swingdev.microconf.mvvm.di

import dagger.Module
import dagger.Provides
import io.swingdev.microconf.mvvm.BuildConfig
import io.swingdev.microconf.mvvm.domain.network.ApiClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesApiClient(): ApiClient =
        Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
}