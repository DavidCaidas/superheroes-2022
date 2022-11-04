package com.iesam.superhero.data.biography

import com.iesam.superhero.data.biography.local.BiographyLocalDataSource
import com.iesam.superhero.data.biography.remote.BiographyRemoteDataSource
import com.iesam.superhero.domain.Biography
import com.iesam.superhero.domain.BiographyRepository

class BiographyDataRepository(
    val localDataSource: BiographyLocalDataSource,
    val remoteDataSource: BiographyRemoteDataSource
) :
    BiographyRepository {

    override fun getBiography(superHeroId: Int): Biography {
        var biography = localDataSource.getBiography(superHeroId)
        if (biography == null) {
            biography = remoteDataSource.getBiography(superHeroId)
            if (biography != null) {
                localDataSource.save(superHeroId, biography)
            }
        }
        return biography!!
    }
}