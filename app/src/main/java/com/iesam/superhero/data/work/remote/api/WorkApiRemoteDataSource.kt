package com.iesam.superhero.data.work.remote.api

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.work.remote.WorkRemoteDataSource
import com.iesam.superhero.domain.Work

class WorkApiRemoteDataSource(private val apiClient: ApiClient) : WorkRemoteDataSource {

    override fun getWork(superHeroId: Int): Work? {
        return apiClient.getWork(superHeroId)?.toDomain()
    }
}