package com.iesam.superhero.data.superheroe.remote

data class SuperHeroApiModel(
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