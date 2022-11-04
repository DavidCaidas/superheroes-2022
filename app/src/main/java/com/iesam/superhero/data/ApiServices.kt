package com.iesam.superhero.data

import com.iesam.superhero.data.biography.remote.BiographyApiModel
import com.iesam.superhero.data.connections.remote.ConnectionsApiModel
import com.iesam.superhero.data.powerstats.remote.PowerStatsApiModel
import com.iesam.superhero.data.superheroe.remote.SuperHeroApiModel
import com.iesam.superhero.data.work.remote.WorkApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Endpoints o Servicios para SuperHeros
 */
interface ApiServices {
    @GET("all.json")
    fun getSuperHeroesFeed(): Call<List<SuperHeroApiModel>>

    @GET("id/{heroId}.json")
    fun getSuperHero(@Path("heroId") heroId: Int): Call<SuperHeroApiModel>

    @GET("biography/{heroId}.json")
    fun getBiography(@Path("heroId") heroId: Int): Call<BiographyApiModel>

    @GET("work/{heroId}.json")
    fun getWork(@Path("heroId") heroId: Int): Call<WorkApiModel>

    @GET("connections/{heroId}.json")
    fun getConnections(@Path("heroId") heroId: Int): Call<ConnectionsApiModel>

    @GET("powerstats/{heroId}.json")
    fun getPowerstats(@Path("heroId") heroId: Int): Call<PowerStatsApiModel>
}