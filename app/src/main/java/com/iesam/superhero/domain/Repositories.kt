package com.iesam.superhero.domain

interface SuperHeroRepository {
    fun getSuperHero(): List<SuperHero>
    fun getSuperHeroById(superHeroId: Int): SuperHero?
}

interface BiographyRepository {
    fun getBiography(superHeroId: Int): Biography
}

interface WorkRepository {
    fun getWork(superHeroId: Int): Work
}

interface ConnectionsRepository {
    fun getConnections(superHeroId: Int): Connections
}

interface PowerStatsRepository {
    fun getPowerStats(superHeroId: Int): PowerStats
}

interface AppearanceRepository {
    fun getAppearance(superHeroId: Int): Appearance
}