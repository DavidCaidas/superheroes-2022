package com.iesam.superheroe.data

import com.iesam.superheroe.data.biography.BiographyApiModel
import com.iesam.superheroe.data.superheroe.SuperHeroeApiModel
import com.iesam.superheroe.data.work.WorkApiModel
import retrofit2.Retrofit


/**
 * Retrofit
 */
class ApiClient {

    private val baseEndPoints: String =
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"

    private val apiServices: ApiServices

    init {
        apiServices = buildApiEndPoints()
    }

    fun createRetrofitClient() = Retrofit.Builder()
        .baseUrl(baseEndPoints)
        .build();

    fun buildApiEndPoints() = createRetrofitClient().create(ApiServices::class.java)

    fun getSuperHeroes(): List<SuperHeroeApiModel> {
        val superHeroes = apiServices.getSuperHeroesFeed()
        val response = superHeroes.execute()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    fun getBiography(superHeroeId: Int): BiographyApiModel? {
        val call = apiServices.getBiography(superHeroeId).execute()
        return if (call.isSuccessful) {
            call.body()
        } else {
            null
        }
    }

    fun getWork(superHeroeId: Int): WorkApiModel? {
        val call = apiServices.getWork(superHeroeId).execute()
        return call.body()
    }
}