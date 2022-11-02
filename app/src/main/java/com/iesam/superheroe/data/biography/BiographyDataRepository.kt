package com.iesam.superheroe.data.biography

import com.iesam.superheroe.data.ApiClient
import com.iesam.superheroe.domain.Biography
import com.iesam.superheroe.domain.BiographyRepository

class BiographyDataRepository(val remoteDataSource: BiographyRemoteDataSource) :
    BiographyRepository {

    override fun getBiography(superHeroeId: Int): Biography {
        return remoteDataSource.getBiography(superHeroeId) ?: Biography("test", "test")
    }
}