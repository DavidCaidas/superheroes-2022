package com.iesam.superheroe.data.superheroe

import com.google.gson.annotations.SerializedName

data class SuperHeroeApiModel(
    val id: Int,
    val name: String,
    val images: Images
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)