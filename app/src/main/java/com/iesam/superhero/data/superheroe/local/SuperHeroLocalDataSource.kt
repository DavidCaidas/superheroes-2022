package com.iesam.superhero.data.superheroe.local

import com.iesam.superhero.domain.SuperHero

interface SuperHeroLocalDataSource {
    fun save(superHeros: List<SuperHero>)
    fun getHeroes(): List<SuperHero>
    fun getHero(heroId: Int): SuperHero?
}