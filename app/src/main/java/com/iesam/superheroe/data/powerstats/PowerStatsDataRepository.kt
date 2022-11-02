package com.iesam.superheroe.data.powerstats

import com.iesam.superheroe.data.connections.remote.ConnectionsRemoteDataSource
import com.iesam.superheroe.data.powerstats.remote.PowerStatsRemoteDataSource
import com.iesam.superheroe.domain.*

class PowerStatsDataRepository(val remoteDataSource: PowerStatsRemoteDataSource) :
    PowerStatsRepository {

    override fun getPowerStats(superHeroeId: Int): PowerStats {
        return remoteDataSource.getPowerStats(superHeroeId)
    }
}