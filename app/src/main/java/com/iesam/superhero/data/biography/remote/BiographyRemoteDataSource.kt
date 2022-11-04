package com.iesam.superhero.data.biography.remote

import com.iesam.superhero.domain.Biography

interface BiographyRemoteDataSource {
    fun getBiography(superHeroId: Int): Biography?
}