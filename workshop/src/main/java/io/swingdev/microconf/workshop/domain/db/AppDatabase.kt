package io.swingdev.microconf.workshop.domain.db

import androidx.room.RoomDatabase

// TODO: Annotate database class
abstract class AppDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "db_cat_facts"
    }
}