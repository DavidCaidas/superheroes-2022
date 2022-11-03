package com.iesam.superhero.data.superheroe.local.xml

import android.content.SharedPreferences
import com.google.gson.Gson
import com.iesam.superhero.data.powerstats.local.PowerStatsLocalDataSource
import com.iesam.superhero.data.superheroe.local.SuperHeroLocalDataSource
import com.iesam.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val sharedPreferences: SharedPreferences) :
    SuperHeroLocalDataSource {
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    override fun save(superHeros: List<SuperHero>) {
        superHeros.forEach { superHero ->
            editor.putString(superHero.id.toString(), gson.toJson(superHero))
        }
        editor.apply()
    }

    override fun getHeroes(): List<SuperHero> {
        val superHeros: MutableList<SuperHero> = mutableListOf()
        sharedPreferences.all.forEach { map ->
            superHeros.add(gson.fromJson(map.value as String, SuperHero::class.java))
        }
        return superHeros
    }

    override fun getHero(heroId: Int): SuperHero? {
        return sharedPreferences.getString(heroId.toString(), null)?.let {
            gson.fromJson(it, SuperHero::class.java)
        }
    }
}