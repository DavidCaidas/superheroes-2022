package com.iesam.superhero.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iesam.app.extensions.loadUrl
import com.iesam.superhero.domain.GetSuperHeroFeedUseCase
import com.iesam.superhero.presentation.SuperHeroDetailActivity
import com.iesam.superheroe.databinding.ViewItemSuperheroeFeedBinding

class SuperHeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(superHero: GetSuperHeroFeedUseCase.SuperHeroFeed) {
        val binding = ViewItemSuperheroeFeedBinding.bind(view)
        binding.imgSuperheroe.loadUrl(superHero.urlImage)
        binding.labelNameSuperheroe.text = superHero.nameSuperHero
        binding.labelRealnameSuperheroe.text = superHero.realName
        binding.labelOccupationSuperheroe.text = superHero.occupation
        view.setOnClickListener {
            view.context.startActivity(
                SuperHeroDetailActivity.getIntent(
                    view.context, superHero.id
                )
            )
        }
    }

}