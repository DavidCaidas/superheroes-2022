package com.iesam.superheroe.presentation

import com.iesam.superheroe.domain.GetSuperHeroeFeedUseCase
import com.iesam.superheroe.domain.SuperHeroe

interface SuperHeroeCallback {
    fun onCall(superHeroesFeed: List<GetSuperHeroeFeedUseCase.SuperHeroeFeed>)
}