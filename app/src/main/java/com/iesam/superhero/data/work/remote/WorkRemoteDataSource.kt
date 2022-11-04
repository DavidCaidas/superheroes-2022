package com.iesam.superhero.data.work.remote

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.work.toDomain
import com.iesam.superhero.domain.Work

class WorkRemoteDataSource(private val apiClient: ApiClient) {

    fun getWork(superHeroId: Int): Work? {
        return apiClient.getWork(superHeroId)?.toDomain()
    }
}