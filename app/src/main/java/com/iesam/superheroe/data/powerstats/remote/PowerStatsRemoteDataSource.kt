package com.iesam.superheroe.data.powerstats.remote

import com.iesam.superheroe.data.ApiClient
import com.iesam.superheroe.domain.Connections
import com.iesam.superheroe.domain.PowerStats
import com.iesam.superheroe.domain.SuperHeroe

class PowerStatsRemoteDataSource(val apiClient: ApiClient) {

    fun getPowerStats(superHeroeId: Int): PowerStats {
        val powerStats = apiClient.getPowerStats(superHeroeId)!!
        return powerStats.toDomain()
    }
}