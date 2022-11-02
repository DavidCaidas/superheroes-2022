package com.iesam.superhero.data.powerstats.remote

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.domain.PowerStats

class PowerStatsRemoteDataSource(val apiClient: ApiClient) {

    fun getPowerStats(superHeroId: Int): PowerStats {
        val powerStats = apiClient.getPowerStats(superHeroId)!!
        return powerStats.toDomain()
    }
}