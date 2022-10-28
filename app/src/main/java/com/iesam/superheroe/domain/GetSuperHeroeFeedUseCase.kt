package com.iesam.superheroe.domain

class GetSuperHeroeFeedUseCase(
    val superHeroeRepository: SuperHeroeRepository,
    val biographyRepository: BiographyRepository,
    val workRepository: WorkRepository
) {

    fun execute(): List<SuperHeroeFeed> {
        val superHeroes = superHeroeRepository.getSuperHeroe()

        return superHeroes.map { superHeroe ->
            val work = workRepository.getWork(superHeroe.id)
            val biography = biographyRepository.getBiography(superHeroe.id)

            SuperHeroeFeed(
                superHeroe.id,
                superHeroe.name,
                superHeroe.getUrlImageM(),
                work.occupation,
                biography.realName,
            )
        }
    }

    data class SuperHeroeFeed(
        val id: Int,
        val nameSuperHeroe: String,
        val urlImage: String,
        val occupation: String,
        val realName: String
    )
}