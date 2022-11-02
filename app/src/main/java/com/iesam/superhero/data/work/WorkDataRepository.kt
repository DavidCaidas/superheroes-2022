package com.iesam.superhero.data.work

import com.iesam.superhero.data.work.remote.WorkRemoteDataSource
import com.iesam.superhero.domain.Work
import com.iesam.superhero.domain.WorkRepository

class WorkDataRepository(val remoteDataSource: WorkRemoteDataSource) :
    WorkRepository {

    override fun getWork(superHeroId: Int): Work {
        return remoteDataSource.getWork(superHeroId) ?: Work("Programador")
    }
}