package com.iesam.superheroe.data.superheroe.remote

import com.iesam.superheroe.domain.SuperHeroe

fun SuperHeroeApiModel.toDomain(): SuperHeroe {
    return SuperHeroe(
        this.id, this.name, listOf(
            this.images.xs, this.images.sm, this.images.md, this.images.lg
        )
    )
}
