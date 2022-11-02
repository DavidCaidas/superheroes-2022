package com.iesam.superheroe.data.superheroe.local

import com.iesam.superheroe.domain.SuperHeroe

interface SuperHeroeLocalDataSource {
    fun save(superHeroes: List<SuperHeroe>)
    fun getHeroes(): List<SuperHeroe>
}