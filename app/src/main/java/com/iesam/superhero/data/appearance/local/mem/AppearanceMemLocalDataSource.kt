package com.iesam.superhero.data.appearance.local.mem

import com.iesam.superhero.data.appearance.local.AppearanceLocalDataSource
import com.iesam.superhero.domain.Appearance

class AppearanceMemLocalDataSource : AppearanceLocalDataSource {
    override fun save(heroId: Int, appearance: Appearance) {
        //implementar
    }

    override fun getAppearance(heroId: Int): Appearance? {
        //mock
        return Appearance("male", "human")
    }
}