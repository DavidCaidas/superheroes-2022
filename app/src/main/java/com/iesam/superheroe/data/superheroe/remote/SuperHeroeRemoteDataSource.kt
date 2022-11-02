package com.iesam.superheroe.data.superheroe.remote

import com.iesam.superheroe.data.ApiClient
import com.iesam.superheroe.domain.SuperHeroe

class SuperHeroeRemoteDataSource(val apiClient: ApiClient) {

    fun getSuperHeroes(): List<SuperHeroe> {
        val superHeroes = apiClient.getSuperHeroes().subList(0, 5)
        return superHeroes.map {
            it.toDomain()
        }
    }
}