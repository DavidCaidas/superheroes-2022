package com.iesam.superheroe.data.biography

import com.google.gson.annotations.SerializedName

data class BiographyApiModel(
    @SerializedName("fullName") val fullName: String,
    @SerializedName("alignment") val alignment: String
)