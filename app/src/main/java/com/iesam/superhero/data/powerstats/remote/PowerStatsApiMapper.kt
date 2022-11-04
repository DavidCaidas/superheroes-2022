package com.iesam.superhero.data.powerstats.remote

import com.iesam.superhero.domain.PowerStats

fun PowerStatsApiModel.toDomain() =
    PowerStats(this.intelligence, this.speed, this.combat)

