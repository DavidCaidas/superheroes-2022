package com.iesam.superheroe.data.biography

import com.iesam.superheroe.domain.Biography

fun BiographyApiModel.toDomain() = Biography(this.fullName)