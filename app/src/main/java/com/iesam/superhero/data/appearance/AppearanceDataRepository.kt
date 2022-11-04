package com.iesam.superhero.data.appearance

import com.iesam.superhero.data.appearance.local.AppearanceLocalDataSource
import com.iesam.superhero.data.appearance.remote.AppearanceRemoteDataSource
import com.iesam.superhero.domain.Appearance
import com.iesam.superhero.domain.AppearanceRepository

class AppearanceDataRepository(
    val localDataSource: AppearanceLocalDataSource, val remoteDataSource: AppearanceRemoteDataSource
) : AppearanceRepository {

    override fun getAppearance(superHeroId: Int): Appearance {
        var appearance = localDataSource.getAppearance(superHeroId)
        if (appearance == null) {
            appearance = remoteDataSource.getAppearance(superHeroId)!! //Siempre devuelve un work
            localDataSource.save(superHeroId, appearance)
        }
        return appearance
    }
}