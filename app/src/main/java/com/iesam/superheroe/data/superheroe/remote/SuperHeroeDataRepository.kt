package com.iesam.superheroe.data.superheroe.remote

import com.iesam.superheroe.domain.SuperHeroe
import com.iesam.superheroe.domain.SuperHeroeRepository

class SuperHeroeDataRepository(val remoteSource: SuperHeroeRemoteDataSource) :
    SuperHeroeRepository {

    override fun getSuperHeroe(): List<SuperHeroe> {
        return remoteSource.getSuperHeroes()
    }
}