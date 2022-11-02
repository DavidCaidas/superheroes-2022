package com.iesam.superhero.domain

class GetSuperHeroDetailUseCase(
    private val superHeroRepository: SuperHeroRepository,
    private val biographyRepository: BiographyRepository,
    private val workRepository: WorkRepository,
    private val connectionsRepository: ConnectionsRepository,
    private val powerStatsRepository: PowerStatsRepository
) {

    fun execute(superHeroId: Int) {
        val superHero = superHeroRepository.getSuperHero()
    }

    data class SuperHeroDetail(
        val mainImageUrl: String,
        val nameSuperHero: String,
        val alignment: String,
        val realName: String,
        val groupAffiliation: String,
        val intelligence: String,
        val speed: String,
        val combat: String,
        val urlImageS: String,
        val urlImageM: String,
        val urlImageL: String,
        val urlImageXL: String
    )
}