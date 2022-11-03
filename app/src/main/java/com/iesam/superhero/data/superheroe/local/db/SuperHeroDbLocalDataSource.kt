package com.iesam.superhero.data.superheroe.local.db

import com.iesam.superhero.data.powerstats.local.PowerStatsLocalDataSource
import com.iesam.superhero.data.superheroe.local.SuperHeroLocalDataSource
import com.iesam.superhero.domain.SuperHero

class SuperHeroDbLocalDataSource : SuperHeroLocalDataSource {
    override fun save(superHero: List<SuperHero>) {
        TODO("Not yet implemented")
    }

    override fun getHeroes(): List<SuperHero> {
        TODO("Not yet implemented")
    }

    override fun getHero(heroId: Int): SuperHero? {
        TODO("Not yet implemented")
    }
}