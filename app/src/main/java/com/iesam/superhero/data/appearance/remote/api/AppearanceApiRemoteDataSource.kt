package com.iesam.superhero.data.appearance.remote.api

import com.iesam.superhero.data.appearance.remote.AppearanceRemoteDataSource
import com.iesam.superhero.domain.Appearance

class AppearanceApiRemoteDataSource : AppearanceRemoteDataSource {
    override fun getAppearance(heroId: Int): Appearance? {
        //mock
        return Appearance("male", "human")
    }
}