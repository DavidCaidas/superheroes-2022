package com.iesam.superhero.data.work

import com.iesam.superhero.data.work.local.mem.WorkMemLocalDataSource
import com.iesam.superhero.data.work.remote.WorkRemoteDataSource
import com.iesam.superhero.domain.Work
import com.iesam.superhero.domain.WorkRepository

class WorkDataRepository(
    private val localDataSource: WorkMemLocalDataSource,
    private val remoteDataSource: WorkRemoteDataSource
) : WorkRepository {

    override fun getWork(superHeroId: Int): Work {
        var work = localDataSource.getWork(superHeroId)
        if (work == null) {
            work = remoteDataSource.getWork(superHeroId)!! //Siempre devuelve un work
            localDataSource.save(superHeroId, work)
        }
        return work
    }
}