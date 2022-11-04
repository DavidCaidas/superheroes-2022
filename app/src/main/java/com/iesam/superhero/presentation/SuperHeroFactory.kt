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
import com.iesam.superhero.data.superheroe.local.db.SuperHeroDbLocalDataSource
import com.iesam.superhero.data.superheroe.remote.SuperHeroRemoteDataSource
import com.iesam.superhero.data.work.WorkDataRepository
import com.iesam.superhero.data.work.local.mem.WorkMemLocalDataSource
import com.iesam.superhero.data.work.remote.WorkRemoteDataSource
import com.iesam.superhero.domain.*

class SuperHeroFactory {

    fun getSuperHerosViewModel(applicationContext: Context) =
        SuperHerosViewModel(getSuperHeroUseCase(applicationContext))

    fun getSuperHeroDetailViewModel(
        applicationContext: Context
    ): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(
            getSuperHeroDetailUseCase(applicationContext)
        )
    }

    private fun getSuperHeroUseCase(context: Context): GetSuperHeroFeedUseCase {
        return GetSuperHeroFeedUseCase(
            getSuperHeroRepository(context),
            getBiographyRepository(),
            getWorkRepository(),
        )
    }

    private fun getSuperHeroDetailUseCase(
        applicationContext: Context
    ): GetSuperHeroDetailUseCase {
        return GetSuperHeroDetailUseCase(
            getSuperHeroRepository(applicationContext),
            getBiographyRepository(),
            getWorkRepository(),
            getConnectionsRepository(applicationContext),
            getPowerStatsRepository(getSharedPreferences(applicationContext, "power_stats"))
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

    fun getSuperHeroRepository(context: Context): SuperHeroRepository {
        return SuperHeroDataRepository(
            SuperHeroDbLocalDataSource(DataBaseSingleton.getInstance(context).superHeroDao()),
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

    private fun getSharedPreferences(
        context: Context,
        nameSharedPreferences: String
    ): SharedPreferences {
        return context.getSharedPreferences(nameSharedPreferences, Context.MODE_PRIVATE)
    }

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
        private val dataStore: MutableMap<Int, SuperHero> = mutableMapOf()

        fun put(id: Int, biography: SuperHero) {
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