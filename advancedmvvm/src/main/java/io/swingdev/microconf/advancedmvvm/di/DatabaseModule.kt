package io.swingdev.microconf.advancedmvvm.di

import android.content.Context
import androidx.room.Room
import io.swingdev.microconf.advancedmvvm.domain.db.AppDatabase
import io.swingdev.microconf.advancedmvvm.domain.db.CatFactsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun providesCatFactDao(database: AppDatabase): CatFactsDao = database.catFactsDao()

}
