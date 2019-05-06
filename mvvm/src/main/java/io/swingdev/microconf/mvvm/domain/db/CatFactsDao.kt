package io.swingdev.microconf.mvvm.domain.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.swingdev.microconf.mvvm.domain.model.CatFact

@Dao
interface CatFactsDao {

    @Query("SELECT * FROM tb_facts")
    fun getAll(): LiveData<List<CatFact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(facts: List<CatFact>)

    @Query("DELETE FROM tb_facts")
    fun clearAll()
}