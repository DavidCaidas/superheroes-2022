package com.iesam.superhero.data.superheroe.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface SuperHeroDao {

    @Query("SELECT * FROM $TABLA_NAME_SUPERHERO")
    fun findAll(): List<SuperHeroEntity>

    @Query("SELECT * FROM $TABLA_NAME_SUPERHERO WHERE $PK_NAME_SUPERHERO = :heroId LIMIT 1")
    fun findById(heroId: Int): SuperHeroEntity?

    @Insert
    fun save(superHeroEntity: SuperHeroEntity)
}