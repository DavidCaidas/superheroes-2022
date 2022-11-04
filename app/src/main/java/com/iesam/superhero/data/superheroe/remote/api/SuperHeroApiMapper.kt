package com.iesam.superhero.data.superheroe.remote.api

import com.iesam.superhero.domain.SuperHero

fun SuperHeroApiModel.toDomain(): SuperHero {
    return SuperHero(
        this.id, this.name, listOf(
            this.images.xs, this.images.sm, this.images.md, this.images.lg
        )
    )
}
