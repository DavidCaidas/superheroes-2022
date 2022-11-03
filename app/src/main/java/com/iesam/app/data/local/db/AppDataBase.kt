package com.iesam.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iesam.superhero.data.connections.local.db.ConnectionsDao
import com.iesam.superhero.data.connections.local.db.ConnectionsEntity

@Database(entities = [ConnectionsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun connectionsDao(): ConnectionsDao
}