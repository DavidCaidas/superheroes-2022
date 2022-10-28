package com.iesam.superheroe.presentation

import com.iesam.superheroe.data.ApiClient
import com.iesam.superheroe.data.biography.BiographyDataRepository
import com.iesam.superheroe.data.biography.BiographyRemoteDataSource
import com.iesam.superheroe.data.superheroe.SuperHeroeDataRepository
import com.iesam.superheroe.data.superheroe.SuperHeroeRemoteDataSource
import com.iesam.superheroe.data.work.WorkDataRepository
import com.iesam.superheroe.data.work.WorkRemoteDataSource
import com.iesam.superheroe.domain.GetSuperHeroeFeedUseCase

class SuperHeroeFactory {

    fun getSuperHeroeUseCase(): GetSuperHeroeFeedUseCase {
        val apiClient = ApiClient()
        return GetSuperHeroeFeedUseCase(
            SuperHeroeDataRepository(SuperHeroeRemoteDataSource(apiClient)),
            BiographyDataRepository(BiographyRemoteDataSource(apiClient)),
            WorkDataRepository(WorkRemoteDataSource(apiClient)),
        )
    }

}