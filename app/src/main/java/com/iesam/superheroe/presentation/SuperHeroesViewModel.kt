package com.iesam.superheroe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesam.superheroe.domain.GetSuperHeroeFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuperHeroesViewModel(private val getSuperHeroesFeed: GetSuperHeroeFeedUseCase) : ViewModel() {



    fun loadSuperHeroes(superHeroeCallback: SuperHeroeCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val superHeroesFeed = getSuperHeroesFeed.execute()
            withContext(Dispatchers.Main) {
                superHeroeCallback.onCall(superHeroesFeed)
            }
        }
    }

}