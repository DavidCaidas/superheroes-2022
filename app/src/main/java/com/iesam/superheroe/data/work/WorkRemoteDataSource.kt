package com.iesam.superheroe.data.work

import com.iesam.superheroe.data.ApiClient
import com.iesam.superheroe.domain.Work

class WorkRemoteDataSource (private val apiClient: ApiClient) {

    fun getWork(superHeroeId: Int): Work?{
        return apiClient.getWork(superHeroeId)?.toDomain()
    }
}