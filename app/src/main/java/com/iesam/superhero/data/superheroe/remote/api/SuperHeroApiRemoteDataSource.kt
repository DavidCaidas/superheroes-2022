package com.iesam.superhero.data.superheroe.remote.api

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.superheroe.remote.SuperHeroRemoteDataSource
import com.iesam.superhero.domain.SuperHero

class SuperHeroApiRemoteDataSource(val apiClient: ApiClient) : SuperHeroRemoteDataSource {

    override fun getSuperHeroes(): List<SuperHero> {
        val superHeros = apiClient.getSuperHeroes().subList(0, 15)
        return superHeros.map {
            it.toDomain()
        }
    }

    override fun getSuperHero(superHeroId: Int): SuperHero? {
        return apiClient.getSuperHero(superHeroId)?.toDomain()
    }
}