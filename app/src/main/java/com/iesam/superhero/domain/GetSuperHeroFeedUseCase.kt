package com.iesam.superhero.domain

class GetSuperHeroFeedUseCase(
    private val superHeroRepository: SuperHeroRepository,
    private val biographyRepository: BiographyRepository,
    private val workRepository: WorkRepository
) {

    fun execute(): List<SuperHeroFeed> {
        val superHeros = superHeroRepository.getSuperHero()


        val list = superHeros.map { superHero ->
            val work = workRepository.getWork(superHero.id)
            val biography = biographyRepository.getBiography(superHero.id)

            SuperHeroFeed(
                superHero.id,
                superHero.name,
                superHero.getUrlImageM(),
                work.occupation,
                biography.realName,
            )
        }

        return list
    }

    data class SuperHeroFeed(
        val id: Int,
        val nameSuperHero: String,
        val urlImage: String,
        val occupation: String,
        val realName: String
    )
}