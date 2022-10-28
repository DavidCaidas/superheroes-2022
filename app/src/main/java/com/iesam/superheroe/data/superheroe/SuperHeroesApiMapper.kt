package com.iesam.superheroe.data.superheroe

import com.iesam.superheroe.domain.SuperHeroe

fun SuperHeroeApiModel.toDomain(): SuperHeroe{
    return SuperHeroe(this.id, this.name, this.urlImages)
}