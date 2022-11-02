package com.iesam.superhero.data.powerstats

import com.iesam.superhero.data.powerstats.remote.PowerStatsRemoteDataSource
import com.iesam.superhero.domain.*

class PowerStatsDataRepository(val remoteDataSource: PowerStatsRemoteDataSource) :
    PowerStatsRepository {

    override fun getPowerStats(superHeroId: Int): PowerStats {
        return remoteDataSource.getPowerStats(superHeroId)
    }
}