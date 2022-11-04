package com.iesam.superhero.data.work.remote

import com.iesam.superhero.domain.Work

interface WorkRemoteDataSource {
    fun getWork(superHeroId: Int): Work?
}