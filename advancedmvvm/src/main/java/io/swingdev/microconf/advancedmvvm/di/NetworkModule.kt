package io.swingdev.microconf.advancedmvvm.di

import dagger.Module
import dagger.Provides
import io.swingdev.microconf.advancedmvvm.BuildConfig
import io.swingdev.microconf.advancedmvvm.domain.network.ApiClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
}