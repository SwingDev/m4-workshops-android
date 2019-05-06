package io.swingdev.microconf.mvc.di

import android.content.Context
import androidx.room.Room
import io.swingdev.microconf.mvc.domain.db.AppDatabase
import io.swingdev.microconf.mvc.domain.db.CatFactsDao
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
