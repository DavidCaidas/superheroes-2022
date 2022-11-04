package com.iesam.superhero.data.connections.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_CONNECTIONS = "connections"

@Entity(tableName = TABLE_NAME_CONNECTIONS)
data class ConnectionsEntity(
    @PrimaryKey val heroId: Int,
    @ColumnInfo(name = "group_affiliation") val groupAffiliation: String
)