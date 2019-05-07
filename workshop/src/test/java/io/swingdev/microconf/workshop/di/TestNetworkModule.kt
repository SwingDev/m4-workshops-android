package io.swingdev.microconf.workshop.di

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import io.reactivex.Maybe
import io.swingdev.microconf.workshop.domain.network.ApiClient
import io.swingdev.microconf.workshop.utils.TestObjects
import javax.inject.Singleton

@Module
class TestNetworkModule {

    @Provides
    @Singleton
    fun providesApiClient(): ApiClient = mock {
        on { getCatFacts(any()) } doReturn Maybe.just(TestObjects.newFacts)
    }
}