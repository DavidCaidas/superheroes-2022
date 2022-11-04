package com.iesam.superhero.data.connections.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConnectionsDao {

    @Query("SELECT * FROM $TABLE_NAME_CONNECTIONS WHERE heroId = :heroId LIMIT 1")
    fun findById(heroId: Int): ConnectionsEntity?

    @Insert
    fun save(connectionsEntity: ConnectionsEntity): Long
}