package com.iesam.superhero.data.connections.remote.api

import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.connections.remote.ConnectionsRemoteDataSource
import com.iesam.superhero.domain.Connections

class ConnectionsApiRemoteDataSource(val apiClient: ApiClient) : ConnectionsRemoteDataSource {

    override fun getConnections(superHeroId: Int): Connections {
        val connections = apiClient.getConnections(superHeroId)!!
        return connections.toDomain()
    }
}