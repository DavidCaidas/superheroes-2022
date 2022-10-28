package com.iesam.superheroe.data.biography

import com.iesam.superheroe.data.ApiClient
import com.iesam.superheroe.domain.Biography
import com.iesam.superheroe.domain.BiographyRepository

class BiographyDataRepository(val client: ApiClient) : BiographyRepository {

    override fun getBiography(superHeroeId: Int): Biography {
        val bio = client.getBiography(superHeroeId)
        return if(bio == null){
            Biography("nombre completo")
        }else{
            bio.toDomain()
        }
    }
}