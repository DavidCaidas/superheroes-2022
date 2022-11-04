package com.iesam.superhero.data.connections.remote.api

import com.iesam.superhero.domain.Connections

fun ConnectionsApiModel.toDomain(): Connections {
    return Connections(this.groupAffiliation)
}
