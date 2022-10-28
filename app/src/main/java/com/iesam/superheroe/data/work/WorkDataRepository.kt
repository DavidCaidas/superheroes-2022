package com.iesam.superheroe.data.work

import com.iesam.superheroe.domain.Biography
import com.iesam.superheroe.domain.Work
import com.iesam.superheroe.domain.WorkRepository

class WorkDataRepository(val remoteDataSource: WorkRemoteDataSource) :
    WorkRepository {

    override fun getWork(superHeroeId: Int): Work {
        return remoteDataSource.getWork(superHeroeId) ?: Work("Programador")
    }
}