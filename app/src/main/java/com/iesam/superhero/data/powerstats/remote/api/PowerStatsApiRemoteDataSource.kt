package com.iesam.superhero.data.powerstats.remote.api

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.powerstats.remote.PowerStatsRemoteDataSource
import com.iesam.superhero.domain.PowerStats

class PowerStatsApiRemoteDataSource(val apiClient: ApiClient) : PowerStatsRemoteDataSource {

    override fun getPowerStats(superHeroId: Int): PowerStats {
        val powerStats = apiClient.getPowerStats(superHeroId)!!
        return powerStats.toDomain()
    }
}