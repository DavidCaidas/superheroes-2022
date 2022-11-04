package com.iesam.superhero.data.connections

import com.iesam.superhero.data.connections.local.ConnectionsLocalDataSource
import com.iesam.superhero.data.connections.remote.ConnectionsRemoteDataSource
import com.iesam.superhero.domain.Connections
import com.iesam.superhero.domain.ConnectionsRepository

class ConnectionsDataRepository(
    val localDataSource: ConnectionsLocalDataSource,
    val remoteDataSource: ConnectionsRemoteDataSource
) :
    ConnectionsRepository {

    override fun getConnections(superHeroId: Int): Connections {
        var connections = localDataSource.findByHeroId(superHeroId)
        if (connections == null) {
            connections = remoteDataSource.getConnections(superHeroId)
            localDataSource.save(superHeroId, connections)
        }
        return connections
    }
}