package com.iesam.superhero.data.work.remote.api

import com.iesam.superhero.domain.Work

fun WorkApiModel.toDomain() = Work(this.occupation)