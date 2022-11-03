package com.iesam.superhero.data.biography.local.mem

import com.iesam.app.data.local.mem.MemDataStore
import com.iesam.superhero.data.biography.local.BiographyLocalDataSource
import com.iesam.superhero.domain.Biography
import com.iesam.superhero.presentation.SuperHeroFactory

class BiographyMemLocalDataSource(private val dataStore: MemDataStore<Biography>) :
    BiographyLocalDataSource {

    override fun save(heroId: Int, biography: Biography) {
        dataStore.put(heroId.toString(), biography)
    }

    override fun getBiography(heroId: Int): Biography? {
        return dataStore.get(heroId.toString())
    }
}