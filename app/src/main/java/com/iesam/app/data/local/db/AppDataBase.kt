package com.iesam.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iesam.superhero.data.connections.local.db.ConnectionsDao
import com.iesam.superhero.data.connections.local.db.ConnectionsEntity
import com.iesam.superhero.data.superheroe.local.db.SuperHeroDao
import com.iesam.superhero.data.superheroe.local.db.SuperHeroEntity

@Database(entities = [ConnectionsEntity::class, SuperHeroEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun connectionsDao(): ConnectionsDao
    abstract fun superHeroDao(): SuperHeroDao
}