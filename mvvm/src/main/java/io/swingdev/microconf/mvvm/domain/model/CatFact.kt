package io.swingdev.microconf.mvvm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tb_facts")
data class CatFact(
    @PrimaryKey @SerializedName("_id") val id: String,
    val text: String
)