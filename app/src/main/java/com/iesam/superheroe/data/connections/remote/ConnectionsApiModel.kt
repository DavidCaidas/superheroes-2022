package com.iesam.superheroe.data.connections.remote

import com.google.gson.annotations.SerializedName

data class ConnectionsApiModel(@SerializedName("groupAffiliation") val groupAffiliation: String)