package com.iesam.superhero.data.superheroe.remote

import com.iesam.superhero.domain.SuperHero

interface SuperHeroRemoteDataSource {
    fun getSuperHeroes(): List<SuperHero>
    fun getSuperHero(superHeroId: Int): SuperHero?
}