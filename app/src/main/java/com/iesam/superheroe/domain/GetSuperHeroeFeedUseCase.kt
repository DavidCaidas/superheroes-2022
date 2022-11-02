package com.iesam.superheroe.domain

class GetSuperHeroeFeedUseCase(
    private val superHeroeRepository: SuperHeroeRepository,
    private val biographyRepository: BiographyRepository,
    private val workRepository: WorkRepository
) {

    fun execute(): List<SuperHeroeFeed> {
        val superHeroes = superHeroeRepository.getSuperHeroe()


        val list = superHeroes.map { superHeroe ->
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

        return list
    }

    data class SuperHeroeFeed(
        val id: Int,
        val nameSuperHeroe: String,
        val urlImage: String,
        val occupation: String,
        val realName: String
    )
}