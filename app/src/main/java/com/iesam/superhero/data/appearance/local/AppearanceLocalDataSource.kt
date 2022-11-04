package com.iesam.superhero.data.appearance.local

import com.iesam.superhero.domain.Appearance

interface AppearanceLocalDataSource {
    fun save(heroId: Int, appearance: Appearance)
    fun getAppearance(heroId: Int): Appearance?
}