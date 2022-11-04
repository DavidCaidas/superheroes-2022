package com.iesam.superhero.presentation

import com.iesam.superhero.domain.GetSuperHeroDetailUseCase
import com.iesam.superhero.domain.GetSuperHeroFeedUseCase

interface SuperHeroCallback {
    fun onCall(superHerosFeed: List<GetSuperHeroFeedUseCase.SuperHeroFeed>)
}

interface SuperHeroDetailCallback {
    fun onCall(superHeroDetail: GetSuperHeroDetailUseCase.SuperHeroDetail)
}