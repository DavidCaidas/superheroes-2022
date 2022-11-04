package com.iesam.superhero.data.biography.remote.api

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.biography.remote.BiographyRemoteDataSource
import com.iesam.superhero.domain.Biography

class BiographyApiRemoteDataSource(private val apiClient: ApiClient) : BiographyRemoteDataSource {

    override fun getBiography(superHeroId: Int): Biography? =
        apiClient.getBiography(superHeroId)?.toDomain()
}