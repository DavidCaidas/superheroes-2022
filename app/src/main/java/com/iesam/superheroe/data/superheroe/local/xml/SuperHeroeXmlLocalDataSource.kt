package com.iesam.superheroe.data.superheroe.local.xml

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.iesam.superheroe.data.superheroe.local.SuperHeroeLocalDataSource
import com.iesam.superheroe.domain.SuperHeroe

class SuperHeroeXmlLocalDataSource(val activity: Activity, sharedPreferences: SharedPreferences) :
    SuperHeroeLocalDataSource {
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    val sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE)


    override fun save(superHeroes: List<SuperHeroe>) {
        val editor = sharedPreferences.edit()
        superHeroes.forEach { superHeroe ->
            editor.putString(superHeroe.id.toString(), gson.toJson(superHeroe))
        }
        editor.apply()
    }

    override fun getHeroes(): List<SuperHeroe> {
        val superHeroes: MutableList<SuperHeroe> = mutableListOf()
        sharedPreferences.all.forEach { map ->
            superHeroes.add(gson.fromJson(map.value as String, SuperHeroe::class.java))
        }
        return superHeroes
    }
}