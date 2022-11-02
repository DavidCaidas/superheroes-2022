package com.iesam.superhero.presentation

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.biography.BiographyDataRepository
import com.iesam.superhero.data.biography.remote.BiographyRemoteDataSource
import com.iesam.superhero.data.superheroe.SuperHeroDataRepository
import com.iesam.superhero.data.superheroe.local.xml.SuperHeroXmlLocalDataSource
import com.iesam.superhero.data.superheroe.remote.SuperHeroRemoteDataSource
import com.iesam.superhero.data.work.WorkDataRepository
import com.iesam.superhero.data.work.remote.WorkRemoteDataSource
import com.iesam.superhero.domain.GetSuperHeroFeedUseCase

class SuperHeroFactory {

    fun getSuperHeroUseCase(sharedPreferences: SharedPreferences): GetSuperHeroFeedUseCase {
        val apiClient = ApiClient()
        return GetSuperHeroFeedUseCase(
            SuperHeroDataRepository(
                SuperHeroXmlLocalDataSource(sharedPreferences),
                SuperHeroRemoteDataSource(apiClient)
            ),
            BiographyDataRepository(BiographyRemoteDataSource(apiClient)),
            WorkDataRepository(WorkRemoteDataSource(apiClient)),
        )
    }

    fun getSuperHerosViewModel(sharedPreferences: SharedPreferences) =
        SuperHerosViewModel(getSuperHeroUseCase(sharedPreferences))

}