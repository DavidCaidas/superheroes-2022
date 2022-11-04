package com.iesam.superhero.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesam.superhero.domain.GetSuperHeroFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuperHerosViewModel(private val getSuperHerosFeed: GetSuperHeroFeedUseCase) : ViewModel() {


    fun loadSuperHeros(superHeroCallback: SuperHeroCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val superHerosFeed = getSuperHerosFeed.execute()
            withContext(Dispatchers.Main) {
                superHeroCallback.onCall(superHerosFeed)
            }
        }
    }

}