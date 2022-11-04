package com.iesam.superhero.data.biography.remote

import com.google.gson.annotations.SerializedName

data class BiographyApiModel(
    @SerializedName("fullName") val fullName: String,
    @SerializedName("alignment") val alignment: String
)