package com.iesam.superhero.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesam.superhero.domain.GetSuperHeroDetailUseCase
import com.iesam.superhero.domain.GetSuperHeroFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuperHeroDetailViewModel(private val getSuperHeroDetailUseCase: GetSuperHeroDetailUseCase) :
    ViewModel() {


    fun loadSuperHeroDetails(superHeroId: Int, callback: SuperHeroDetailCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val superHeroDetail = getSuperHeroDetailUseCase.execute(superHeroId)
            withContext(Dispatchers.Main) {
                callback.onCall(superHeroDetail)
            }
        }
    }

}