package com.iesam.superheroe.domain

interface SuperHeroeRepository {
    fun getSuperHeroe(): List<SuperHeroe>
}

interface BiographyRepository {
    fun getBiography(superHeroeId: Int): Biography
}

interface WorkRepository {
    fun getWork(superHeroeId: Int): Work
}

interface ConnectionsRepository {
    fun getConnections(superHeroeId: Int): Connections
}

interface PowerStatsRepository {
    fun getPowerStats(superHeroeId: Int): PowerStats
}