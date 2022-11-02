package com.iesam.superheroe.data.powerstats.remote

import com.iesam.superheroe.domain.Connections
import com.iesam.superheroe.domain.PowerStats
import com.iesam.superheroe.domain.SuperHeroe

fun PowerStatsApiModel.toDomain() =
    PowerStats(this.intelligence, this.speed, this.combat)

