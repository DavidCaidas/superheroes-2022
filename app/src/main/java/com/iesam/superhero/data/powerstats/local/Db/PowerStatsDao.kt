package com.iesam.superhero.data.powerstats.local.Db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PowerStatsDao {

    @Query("SELECT * FROM $TABLE_NAME_POWERSTATS WHERE heroId = :heroId LIMIT 1")
    fun findById(heroId: Int): PowerStatsEntity?

    @Insert
    fun save(powerStatsEntity: PowerStatsEntity)

    @Query("SELECT * FROM $TABLE_NAME_POWERSTATS")
    fun findAll(): List<PowerStatsEntity>
}