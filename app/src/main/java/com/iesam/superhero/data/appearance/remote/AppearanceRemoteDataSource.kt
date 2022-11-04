package com.iesam.superhero.data.appearance.remote

import com.iesam.superhero.domain.Appearance

interface AppearanceRemoteDataSource {
    fun getAppearance(heroId: Int): Appearance?
}