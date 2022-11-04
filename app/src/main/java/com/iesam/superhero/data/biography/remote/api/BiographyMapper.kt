package com.iesam.superhero.data.biography.remote.api

import com.iesam.superhero.domain.Biography

fun BiographyApiModel.toDomain() = Biography(this.fullName, this.alignment)