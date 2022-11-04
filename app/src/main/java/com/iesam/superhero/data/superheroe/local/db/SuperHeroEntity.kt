package com.iesam.superhero.data.superheroe.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLA_NAME_SUPERHERO = "superhero"
const val PK_NAME_SUPERHERO = "id"

@Entity(tableName = TABLA_NAME_SUPERHERO)
data class SuperHeroEntity(
    @PrimaryKey @ColumnInfo(name = PK_NAME_SUPERHERO) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image_s") val urlImageS: String,
    @ColumnInfo(name = "image_m") val urlImageM: String,
    @ColumnInfo(name = "image_l") val urlImageL: String,
    @ColumnInfo(name = "image_xl") val urlImageXL: String,
)