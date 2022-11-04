package com.iesam.superhero.data.connections.local.db

import com.iesam.superhero.domain.Connections

fun ConnectionsEntity.toDomain(): Connections = Connections(this.groupAffiliation)
fun Connections.toEntity(heroId: Int) = ConnectionsEntity(heroId, this.groupAffiliation)