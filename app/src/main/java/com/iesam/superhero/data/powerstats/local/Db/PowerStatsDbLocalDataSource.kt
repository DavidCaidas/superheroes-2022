package com.iesam.superhero.data.powerstats.local.Db

import com.iesam.superhero.data.powerstats.local.PowerStatsLocalDataSource
import com.iesam.superhero.domain.PowerStats

class PowerStatsDbLocalDataSource(private val dao: PowerStatsDao) : PowerStatsLocalDataSource {

    override fun save(heroId: Int, powerStats: PowerStats) {
        dao.save(powerStats.toEntity(heroId))
    }

    override fun getPowerStats(): List<PowerStats> {
        return dao.findAll().map {
            it.toDomain() }
    }

    override fun getPowerStats(heroId: Int): PowerStats? {
        return dao.findById(heroId)?.toDomain()
    }

}
