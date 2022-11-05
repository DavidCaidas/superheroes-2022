package com.iesam.superhero.data.powerstats.local.Db


import com.iesam.superhero.domain.PowerStats

fun PowerStatsEntity.toDomain(): PowerStats = PowerStats(
    this.combat,
    this.intelligence,
    this.speed
)


fun PowerStats.toEntity(heroId: Int) = PowerStatsEntity(
    heroId,
    this.combat,
    this.intelligence,
    this.speed
)

