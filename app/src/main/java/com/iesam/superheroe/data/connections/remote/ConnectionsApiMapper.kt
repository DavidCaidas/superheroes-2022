package com.iesam.superheroe.data.connections.remote

import com.iesam.superheroe.domain.Connections
import com.iesam.superheroe.domain.SuperHeroe

fun ConnectionsApiModel.toDomain(): Connections {
    return Connections(this.groupAffiliation)
}
