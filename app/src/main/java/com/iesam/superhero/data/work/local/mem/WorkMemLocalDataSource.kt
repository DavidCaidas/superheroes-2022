package com.iesam.superhero.data.work.local.mem

import com.iesam.superhero.data.work.local.WorkLocalDataSource
import com.iesam.superhero.domain.Work

class WorkMemLocalDataSource : WorkLocalDataSource {

    private val dataStore: MutableMap<Int, Work> = mutableMapOf()

    override fun save(heroId: Int, work: Work) {
        dataStore.put(heroId, work)
    }

    override fun getWork(heroId: Int): Work? {
        return dataStore[heroId]
    }
}