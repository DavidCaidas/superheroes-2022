package com.iesam.superhero.data.connections.remote

import com.iesam.superhero.domain.Connections

fun ConnectionsApiModel.toDomain(): Connections {
    return Connections(this.groupAffiliation)
}
