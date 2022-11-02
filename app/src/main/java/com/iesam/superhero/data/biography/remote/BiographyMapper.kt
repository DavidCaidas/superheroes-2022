package com.iesam.superhero.data.biography

import com.iesam.superhero.data.biography.remote.BiographyApiModel
import com.iesam.superhero.domain.Biography

fun BiographyApiModel.toDomain() = Biography(this.fullName, this.alignment)