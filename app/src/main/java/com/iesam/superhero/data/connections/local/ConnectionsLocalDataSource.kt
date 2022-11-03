package com.iesam.superhero.data.connections.local

import com.iesam.superhero.domain.Connections

interface ConnectionsLocalDataSource {
    fun findByHeroId(heroId: Int): Connections?
    fun save(heroId: Int, connections: Connections)
}