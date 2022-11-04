package com.iesam.superhero.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.iesam.superhero.domain.GetSuperHeroFeedUseCase
import com.iesam.superhero.presentation.adapter.SuperHeroAdapter
import com.iesam.superheroe.databinding.ActivitySuperheroeFeedBinding

class SuperHerosFeedActivity : AppCompatActivity() {

    private var binding: ActivitySuperheroeFeedBinding? = null
    private val superHeroAdapter = SuperHeroAdapter()
    private val viewModel by lazy {
        SuperHeroFactory().getSuperHerosViewModel(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        loadSuperHeros()
    }

    private fun setupBinding() {
        binding = ActivitySuperheroeFeedBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setupView() {
        binding?.apply {
            listSuperheroe.adapter = superHeroAdapter
            listSuperheroe.layoutManager =
                LinearLayoutManager(
                    this@SuperHerosFeedActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    private fun loadSuperHeros() {
        viewModel.loadSuperHeros(object : SuperHeroCallback {
            override fun onCall(superHerosFeed: List<GetSuperHeroFeedUseCase.SuperHeroFeed>) {
                superHeroAdapter.setDataItems(superHerosFeed)
            }
        })
    }
}