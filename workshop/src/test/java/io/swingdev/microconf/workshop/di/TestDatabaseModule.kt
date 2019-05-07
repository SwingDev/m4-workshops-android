package io.swingdev.microconf.workshop.di

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import io.reactivex.Maybe
import io.swingdev.microconf.workshop.domain.db.CatFactsDao
import io.swingdev.microconf.workshop.utils.TestObjects

@Module
class TestDatabaseModule {

    @Provides
    fun providesCatFactsDao(): CatFactsDao = mock {
        on { getAll() } doReturn Maybe.just(TestObjects.savedFacts)
    }

}