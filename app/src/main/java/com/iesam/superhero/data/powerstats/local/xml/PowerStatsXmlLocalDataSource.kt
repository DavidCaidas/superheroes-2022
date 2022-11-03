package com.iesam.superhero.data.powerstats.local.xml

import android.content.SharedPreferences
import com.google.gson.Gson
import com.iesam.superhero.data.powerstats.local.PowerStatsLocalDataSource
import com.iesam.superhero.domain.PowerStats

class PowerStatsXmlLocalDataSource(private val sharedPreferences: SharedPreferences) :
    PowerStatsLocalDataSource {
    private val editor = sharedPreferences.edit()
    private val gson = Gson()

    override fun save(heroId: Int, powerStats: PowerStats) {
        editor.putString(heroId.toString(), gson.toJson(powerStats, PowerStats::class.java))
        editor.apply()
    }

    override fun getPowerStats(): List<PowerStats> {
        return sharedPreferences.all.map {
            gson.fromJson(it.value as String, PowerStats::class.java)
        }
    }

    override fun getPowerStats(heroId: Int): PowerStats? {
        val jsonPowerStats = sharedPreferences.getString(heroId.toString(), null)
        return jsonPowerStats?.let {
            gson.fromJson(it, PowerStats::class.java)
        }
    }
}