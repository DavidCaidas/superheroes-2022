package com.iesam.superhero.data.connections

import com.iesam.superhero.data.connections.remote.ConnectionsRemoteDataSource
import com.iesam.superhero.domain.*

class ConnectionsDataRepository(val remoteDataSource: ConnectionsRemoteDataSource) :
    ConnectionsRepository {

    override fun getConnections(superHeroId: Int): Connections {
        return remoteDataSource.getConnections(superHeroId)
    }
}