package io.swingdev.microconf.workshop.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.swingdev.microconf.workshop.domain.db.AppDatabase
import io.swingdev.microconf.workshop.domain.db.CatFactsDao
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
    fun providesCatFactsDao(database: AppDatabase): CatFactsDao = database.catFactsDao()

}
