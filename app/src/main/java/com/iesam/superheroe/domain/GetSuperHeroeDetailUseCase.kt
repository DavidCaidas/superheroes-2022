package com.iesam.superheroe.domain

class GetSuperHeroeDetailUseCase  {

    fun execute(superHeroeId: Int){

    }

    data class SuperHeroeDetail(
        val mainImageUrl: String,
        val nameSuperHeroe: String,
        val alignment: String,
        val realName: String,
        val groupAffiliation: String,
        val powerStats: PowerStats

    )
}