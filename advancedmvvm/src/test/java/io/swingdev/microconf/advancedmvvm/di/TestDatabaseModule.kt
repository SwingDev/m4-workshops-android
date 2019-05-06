package io.swingdev.microconf.advancedmvvm.di

import io.swingdev.microconf.advancedmvvm.domain.db.CatFactsDao
import io.swingdev.microconf.advancedmvvm.utils.TestObjects
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import io.reactivex.Maybe
import javax.inject.Singleton

@Module
class TestDatabaseModule {

    @Provides
    @Singleton
    fun providesCatFactsDao(): CatFactsDao = mock {
        on { getAll() } doReturn Maybe.just(TestObjects.savedFacts)
    }
}