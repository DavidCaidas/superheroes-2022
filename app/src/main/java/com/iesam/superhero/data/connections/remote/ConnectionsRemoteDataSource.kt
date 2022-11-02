package com.iesam.superhero.data.connections.remote

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.domain.Connections

class ConnectionsRemoteDataSource(val apiClient: ApiClient) {

    fun getConnections(superHeroId: Int): Connections {
        val connections = apiClient.getConnections(superHeroId)!!
        return connections.toDomain()
    }
}