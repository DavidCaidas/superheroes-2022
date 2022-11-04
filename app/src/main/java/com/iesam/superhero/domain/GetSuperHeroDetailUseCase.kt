package com.iesam.superhero.domain

class GetSuperHeroDetailUseCase(
    private val superHeroRepository: SuperHeroRepository,
    private val biographyRepository: BiographyRepository,
    private val workRepository: WorkRepository,
    private val connectionsRepository: ConnectionsRepository,
    private val powerStatsRepository: PowerStatsRepository,
    private val appearanceRepository: AppearanceRepository,
) {

    fun execute(superHeroId: Int): SuperHeroDetail {
        val superHero = superHeroRepository.getSuperHeroById(superHeroId)!!
        val biography = biographyRepository.getBiography(superHeroId)
        val connections = connectionsRepository.getConnections(superHeroId)
        val powerStats = powerStatsRepository.getPowerStats(superHeroId)
        val appearance = appearanceRepository.getAppearance(superHeroId)
        return SuperHeroDetail(
            superHero.getUrlImageXL(),
            superHero.name,
            biography.alignment,
            biography.realName,
            connections.groupAffiliation,
            powerStats.intelligence,
            powerStats.speed,
            powerStats.combat,
            superHero.urlImages,
            appearance.gender,
            appearance.race
        )
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
        val urlImages: List<String>,
        val gender: String,
        val race: String
    )
}