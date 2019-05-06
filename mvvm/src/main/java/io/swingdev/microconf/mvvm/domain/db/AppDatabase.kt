package io.swingdev.microconf.mvvm.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.swingdev.microconf.mvvm.domain.model.CatFact

@Database(entities = [CatFact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun catFactsDao(): CatFactsDao

    companion object {
        const val DB_NAME = "db_cat_facts"
    }
}