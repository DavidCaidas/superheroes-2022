package com.iesam.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.iesam.superhero.data.ApiClient
import com.iesam.superhero.data.work.WorkDataRepository
import com.iesam.superhero.data.work.local.mem.WorkMemLocalDataSource
import com.iesam.superhero.data.work.remote.WorkRemoteDataSource
import com.iesam.superhero.domain.GetSuperHeroDetailUseCase
import com.iesam.superhero.domain.WorkRepository
import com.iesam.superheroe.R
import com.iesam.superheroe.databinding.ActivitySuperHeroeDetailBinding
import com.iesam.superheroe.databinding.ActivitySuperheroeFeedBinding
import kotlin.concurrent.thread

class SuperHeroDetailActivity : AppCompatActivity() {

    private var viewModel: SuperHeroDetailViewModel? = null
    private var binding: ActivitySuperHeroeDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = SuperHeroFactory().getSuperHeroDetailViewModel(
            getSharedPreferences("superherodetail", Context.MODE_PRIVATE),
            applicationContext
        )
        setupBinding()
        //loadSuperHeroDetail()
        val workRepository: WorkRepository = WorkDataRepository(
            WorkMemLocalDataSource(),
            WorkRemoteDataSource(ApiClient())
        )
        thread {
            val work = workRepository.getWork(1)
            Log.d("@dev", "Work: " + work)
        }

    }

    private fun setupBinding() {
        binding = ActivitySuperHeroeDetailBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun loadSuperHeroDetail() {
        viewModel?.loadSuperHeroDetails(getSuperHeroId(), object : SuperHeroDetailCallback {
            override fun onCall(superHeroDetail: GetSuperHeroDetailUseCase.SuperHeroDetail) {
                Log.d("@dev", "Ok!!")
            }

        })
    }

    private fun getSuperHeroId(): Int = intent.getIntExtra(KEY_SUPERHEROE_ID, 0)

    companion object {

        private val KEY_SUPERHEROE_ID = "key_superheroe_id"

        fun getIntent(context: Context, superHeroId: Int): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHEROE_ID, superHeroId)
            return intent
        }
    }
}