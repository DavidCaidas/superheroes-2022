package com.iesam.superheroe.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.iesam.superheroe.R
import com.iesam.superheroe.databinding.ActivitySuperheroeFeedBinding
import com.iesam.superheroe.domain.GetSuperHeroeFeedUseCase
import com.iesam.superheroe.presentation.adapter.SuperHeroeAdapter
import kotlin.concurrent.thread

class SuperHeroesFeedActivity : AppCompatActivity() {

    private var binding: ActivitySuperheroeFeedBinding? = null
    private val superHeroeAdapter = SuperHeroeAdapter()
    private val viewModel = SuperHeroeFactory().getSuperHeroesViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        loadSuperHeroes()
    }

    private fun setupBinding() {
        binding = ActivitySuperheroeFeedBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setupView() {
        binding?.apply {
            listSuperheroe.adapter = superHeroeAdapter
            listSuperheroe.layoutManager =
                LinearLayoutManager(
                    this@SuperHeroesFeedActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    private fun loadSuperHeroes() {
        viewModel.loadSuperHeroes(object : SuperHeroeCallback {
            override fun onCall(superHeroesFeed: List<GetSuperHeroeFeedUseCase.SuperHeroeFeed>) {
                superHeroeAdapter.setDataItems(superHeroesFeed)
            }
        })
    }
}