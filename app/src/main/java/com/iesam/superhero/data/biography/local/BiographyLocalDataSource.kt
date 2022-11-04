package com.iesam.superhero.data.biography.local

import com.iesam.superhero.domain.Biography

interface BiographyLocalDataSource {
    fun save(heroId: Int, biography: Biography)
    fun getBiography(heroId: Int): Biography?
}