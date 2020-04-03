package com.talentoMobile.fundacionMutuaDePropietarios.features.fetch.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FetchEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    @ColumnInfo(name = "fetchdata")
    val fetchData: Long
)