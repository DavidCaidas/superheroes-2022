package com.iesam.superheroe.data.work

import com.iesam.superheroe.domain.Biography
import com.iesam.superheroe.domain.Work

fun WorkApiModel.toDomain() = Work(this.occupation)