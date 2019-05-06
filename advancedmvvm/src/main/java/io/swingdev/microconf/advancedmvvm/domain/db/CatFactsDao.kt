package io.swingdev.microconf.advancedmvvm.domain.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.swingdev.microconf.advancedmvvm.domain.model.CatFact
import io.reactivex.Maybe

@Dao
interface CatFactsDao {

    @Query("SELECT * FROM tb_facts")
    fun getAll(): Maybe<List<CatFact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(facts: List<CatFact>)

    @Query("DELETE FROM tb_facts")
    fun clearAll()
}