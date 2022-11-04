package com.iesam.superhero.data.work.local

import com.iesam.superhero.domain.Work

interface WorkLocalDataSource {
    fun save(heroId: Int, work: Work)
    fun getWork(heroId: Int): Work?
}