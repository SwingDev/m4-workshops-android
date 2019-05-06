package io.swingdev.microconf.mvvm.di

import android.content.Context
import androidx.room.Room
import io.swingdev.microconf.mvvm.domain.db.AppDatabase
import io.swingdev.microconf.mvvm.domain.db.CatFactsDao
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
    @Singleton
    fun providesCatFactDao(database: AppDatabase): CatFactsDao = database.catFactsDao()

}
