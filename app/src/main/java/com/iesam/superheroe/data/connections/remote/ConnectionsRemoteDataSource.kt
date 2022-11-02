package com.iesam.superheroe.data.connections.remote

import com.iesam.superheroe.data.ApiClient
import com.iesam.superheroe.domain.Connections
import com.iesam.superheroe.domain.SuperHeroe

class ConnectionsRemoteDataSource(val apiClient: ApiClient) {

    fun getConnections(superHeroeId: Int): Connections {
        val connections = apiClient.getConnections(superHeroeId)!!
        return connections.toDomain()
    }
}