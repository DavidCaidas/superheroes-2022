package com.iesam.superhero.presentation

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.iesam.app.data.local.db.AppDatabase
import com.iesam.app.data.local.mem.MemDataStore
import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.biography.BiographyDataRepository
import com.iesam.superhero.data.biography.local.mem.BiographyMemLocalDataSource
import com.iesam.superhero.data.biography.remote.BiographyRemoteDataSource
import com.iesam.superhero.data.connections.ConnectionsDataRepository
import com.iesam.superhero.data.connections.local.db.ConnectionsDbLocalDataSource
import com.iesam.superhero.data.connections.remote.ConnectionsRemoteDataSource
import com.iesam.superhero.data.powerstats.PowerStatsDataRepository
import com.iesam.superhero.data.powerstats.local.xml.PowerStatsXmlLocalDataSource
import com.iesam.superhero.data.powerstats.remote.PowerStatsRemoteDataSource
import com.iesam.superhero.data.superheroe.SuperHeroDataRepository
import com.iesam.superhero.data.superheroe.local.xml.SuperHeroXmlLocalDataSource
import com.iesam.superhero.data.superheroe.remote.SuperHeroRemoteDataSource
import com.iesam.superhero.data.work.WorkDataRepository
import com.iesam.superhero.data.work.local.mem.WorkMemLocalDataSource
import com.iesam.superhero.data.work.remote.WorkRemoteDataSource
import com.iesam.superhero.domain.*

class SuperHeroFactory {

    fun getSuperHerosViewModel(sharedPreferences: SharedPreferences) =
        SuperHerosViewModel(getSuperHeroUseCase(sharedPreferences))

    private fun getSuperHeroUseCase(sharedPreferences: SharedPreferences): GetSuperHeroFeedUseCase {
        return GetSuperHeroFeedUseCase(
            getSuperHeroRepository(sharedPreferences),
            getBiographyRepository(),
            getWorkRepository(),
        )
    }

    private fun getBiographyRepository(): BiographyRepository {
        return BiographyDataRepository(
            BiographyMemLocalDataSource(DataStoreSingletonPlus.getInstance()),
            BiographyRemoteDataSource(getApiClient())
        )
    }

    private fun getConnectionsRepository(applicationContext: Context): ConnectionsRepository {
        return ConnectionsDataRepository(
            ConnectionsDbLocalDataSource(
                DataBaseSingleton.getInstance(applicationContext).connectionsDao()
            ),
            ConnectionsRemoteDataSource(getApiClient())
        )
    }

    private fun getPowerStatsRepository(sharedPreferences: SharedPreferences): PowerStatsRepository {
        return PowerStatsDataRepository(
            PowerStatsXmlLocalDataSource(sharedPreferences),
            PowerStatsRemoteDataSource(getApiClient())
        )
    }

    fun getSuperHeroRepository(sharedPreferences: SharedPreferences): SuperHeroRepository {
        return SuperHeroDataRepository(
            SuperHeroXmlLocalDataSource(sharedPreferences),
            SuperHeroRemoteDataSource(getApiClient())
        )
    }

    fun getWorkRepository(): WorkRepository {
        return WorkDataRepository(
            WorkMemLocalDataSource(),
            WorkRemoteDataSource(getApiClient())
        )
    }

    private fun getApiClient() = ApiClient()

    object DataBaseSingleton {
        private var db: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "db-superhero"
                ).build()
            }
            return db!!
        }

    }

    object DataStoreSingleton {
        private val dataStore: MutableMap<Int, Biography> = mutableMapOf()

        fun put(id: Int, biography: Biography) {
            dataStore.put(id, biography)
        }

        fun get(id: Int) = dataStore[id]
    }

    object DataStoreSingletonPlus {
        private var dataStore: MemDataStore<Biography>? = null

        fun getInstance(): MemDataStore<Biography> {
            if (dataStore == null) {
                dataStore = MemDataStore()
            }
            return dataStore!!
        }
    }
}