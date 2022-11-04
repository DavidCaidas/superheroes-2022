package com.iesam.superhero.data.superheroe.local.db

import com.iesam.superhero.domain.SuperHero

fun SuperHeroEntity.toDomain(): SuperHero = SuperHero(
    this.id, this.name, listOf(this.urlImageS, this.urlImageM, this.urlImageL, this.urlImageXL)
)

fun SuperHero.toEntity() = SuperHeroEntity(
    this.id,
    this.name,
    this.getUrlImageS(),
    this.getUrlImageM(),
    this.getUrlImageL(),
    this.getUrlImageXL()
)