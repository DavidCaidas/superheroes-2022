package com.iesam.superheroe.data

import com.iesam.superheroe.data.biography.BiographyApiModel
import com.iesam.superheroe.data.superheroe.SuperHeroeApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Endpoints o Servicios para SuperHeroes
 */
interface ApiServices {
    @GET("all.json")
    fun getSuperHeroesFeed(): Call<List<SuperHeroeApiModel>>

    @GET("biography/{heroId}.json")
    fun getBiography(@Path("heroId")heroId: Int): Call<BiographyApiModel>
}