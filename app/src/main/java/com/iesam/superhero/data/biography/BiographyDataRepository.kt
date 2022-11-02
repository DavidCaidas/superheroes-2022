package com.iesam.superhero.data.biography

import com.iesam.superhero.data.biography.remote.BiographyRemoteDataSource
import com.iesam.superhero.domain.Biography
import com.iesam.superhero.domain.BiographyRepository

class BiographyDataRepository(val remoteDataSource: BiographyRemoteDataSource) :
    BiographyRepository {

    override fun getBiography(superHeroId: Int): Biography {
        return remoteDataSource.getBiography(superHeroId) ?: Biography("test", "test")
    }
}