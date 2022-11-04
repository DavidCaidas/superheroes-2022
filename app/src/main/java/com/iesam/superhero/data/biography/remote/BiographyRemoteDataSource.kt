package com.iesam.superhero.data.biography.remote

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.biography.toDomain
import com.iesam.superhero.domain.Biography

class BiographyRemoteDataSource(private val apiClient: ApiClient) {

    fun getBiography(superHeroId: Int): Biography? =
        apiClient.getBiography(superHeroId)?.toDomain()
}