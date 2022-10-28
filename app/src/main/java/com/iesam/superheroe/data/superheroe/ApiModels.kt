package com.iesam.superheroe.data.superheroe

import com.google.gson.annotations.SerializedName

data class SuperHeroeApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("images") val urlImages: Images
)

data class Images(
    @SerializedName("xs") val xs: String,
    @SerializedName("sm") val sm: String,
    @SerializedName("md") val md: String,
    @SerializedName("lg") val lg: String
)