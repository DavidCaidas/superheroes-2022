package com.iesam.superhero.data.powerstats.remote

import com.iesam.superhero.domain.PowerStats

interface PowerStatsRemoteDataSource {
    fun getPowerStats(superHeroId: Int): PowerStats
}