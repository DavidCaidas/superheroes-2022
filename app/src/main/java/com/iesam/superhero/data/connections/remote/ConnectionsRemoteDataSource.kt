package com.iesam.superhero.data.connections.remote

import com.iesam.superhero.domain.Connections

interface ConnectionsRemoteDataSource {
    fun getConnections(superHeroId: Int): Connections
}