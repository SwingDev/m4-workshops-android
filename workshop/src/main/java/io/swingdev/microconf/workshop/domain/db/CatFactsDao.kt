package io.swingdev.microconf.workshop.domain.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Maybe
import io.swingdev.microconf.workshop.domain.model.CatFact

@Dao
interface CatFactsDao {

    @Query("SELECT * FROM tb_facts")
    fun getAll(): Maybe<List<CatFact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(facts: List<CatFact>)

    @Query("DELETE FROM tb_facts")
    fun clearAll()
}