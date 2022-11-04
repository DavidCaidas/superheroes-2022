package com.iesam.superhero.data.superheroe.remote

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.domain.SuperHero

class SuperHeroRemoteDataSource(val apiClient: ApiClient) {

    fun getSuperHeroes(): List<SuperHero> {
        val superHeros = apiClient.getSuperHeroes().subList(0, 15)
        return superHeros.map {
            it.toDomain()
        }
    }

    fun getSuperHero(superHeroId: Int): SuperHero? {
        return apiClient.getSuperHero(superHeroId)?.toDomain()
    }
}