package io.swingdev.microconf.advancedmvvm.di

import io.swingdev.microconf.advancedmvvm.domain.network.ApiClient
import io.swingdev.microconf.advancedmvvm.utils.TestObjects
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import io.reactivex.Maybe
import javax.inject.Singleton

@Module
class TestNetworkModule {

    @Provides
    @Singleton
    fun providesApiClient(): ApiClient = mock {
        on { getCatFacts(any()) } doReturn Maybe.just(TestObjects.newFacts)
    }
}