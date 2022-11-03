package com.iesam.superhero.data.powerstats.local

import com.iesam.superhero.domain.PowerStats

interface PowerStatsLocalDataSource {
    fun save(heroId: Int, powerStats: PowerStats)
    fun getPowerStats(): List<PowerStats>
    fun getPowerStats(heroId: Int): PowerStats?
}