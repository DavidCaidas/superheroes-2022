package com.iesam.superhero.data.connections.local.db

import com.iesam.superhero.data.connections.local.ConnectionsLocalDataSource
import com.iesam.superhero.domain.Connections

class ConnectionsDbLocalDataSource(private val dao: ConnectionsDao) : ConnectionsLocalDataSource {

    override fun findByHeroId(heroId: Int): Connections? {
        return dao.findById(heroId)?.toDomain()
    }

    override fun save(heroId: Int, connections: Connections) {
        dao.save(connections.toEntity(heroId))
    }
}