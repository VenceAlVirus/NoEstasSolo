package com.talentoMobile.fundacionMutuaDePropietarios.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.talentoMobile.fundacionMutuaDePropietarios.features.fetch.models.FetchEntity

@Dao
interface FetchDateDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFetchDate(fetchEntity: FetchEntity)

    @Query("SELECT * FROM FetchEntity WHERE id == :fetchId")
    fun getFetchDataById(fetchId: Int): FetchEntity
}