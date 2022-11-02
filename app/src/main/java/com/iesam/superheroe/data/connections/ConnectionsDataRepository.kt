package com.iesam.superheroe.data.connections

import com.iesam.superheroe.data.connections.remote.ConnectionsRemoteDataSource
import com.iesam.superheroe.domain.*

class ConnectionsDataRepository(val remoteDataSource: ConnectionsRemoteDataSource) :
    ConnectionsRepository {

    override fun getConnections(superHeroeId: Int): Connections {
        return remoteDataSource.getConnections(superHeroeId)
    }
}