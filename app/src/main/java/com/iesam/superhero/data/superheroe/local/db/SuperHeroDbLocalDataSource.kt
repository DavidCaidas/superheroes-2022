package com.iesam.superhero.data.superheroe.local.db

import com.iesam.superhero.data.superheroe.local.SuperHeroLocalDataSource
import com.iesam.superhero.domain.SuperHero

class SuperHeroDbLocalDataSource(private val dao: SuperHeroDao) : SuperHeroLocalDataSource {

    override fun save(superHeroes: List<SuperHero>) {
        superHeroes.forEach { superHero ->
            dao.save(superHero.toEntity())
        }
    }

    override fun getHeroes(): List<SuperHero> {
        return dao.findAll().map {
            it.toDomain()
        }
    }

    override fun getHero(heroId: Int): SuperHero? {
        return dao.findById(heroId)?.toDomain()
    }
}