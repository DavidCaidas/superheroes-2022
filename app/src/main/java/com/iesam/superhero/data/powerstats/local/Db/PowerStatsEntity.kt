package com.iesam.superhero.data.powerstats.local.Db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_POWERSTATS = "powerstats"

@Entity(tableName = TABLE_NAME_POWERSTATS)
data class PowerStatsEntity(
    @PrimaryKey val heroId: Int,
    @ColumnInfo(name = "intelligence") val intelligence: String,
    @ColumnInfo(name = "speed") val speed: String,
    @ColumnInfo(name = "combat") val combat: String
)