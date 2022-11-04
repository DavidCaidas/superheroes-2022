package com.iesam.superhero.data.work

import com.iesam.superhero.data.work.remote.WorkApiModel
import com.iesam.superhero.domain.Work

fun WorkApiModel.toDomain() = Work(this.occupation)