package com.iesam.superheroe.data.biography

import com.iesam.superheroe.data.ApiClient
import com.iesam.superheroe.domain.Biography

class BiographyRemoteDataSource(private val apiClient: ApiClient) {

    fun getBiography(superHeroeId: Int): Biography? =
        apiClient.getBiography(superHeroeId)?.toDomain()
}