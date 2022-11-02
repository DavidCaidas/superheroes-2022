package com.iesam.superheroe.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iesam.app.extensions.loadUrl
import com.iesam.superheroe.databinding.ViewItemSuperheroeFeedBinding
import com.iesam.superheroe.domain.GetSuperHeroeFeedUseCase

class SuperHeroeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(superHeroe: GetSuperHeroeFeedUseCase.SuperHeroeFeed) {
        val binding = ViewItemSuperheroeFeedBinding.bind(view)
        binding.imgSuperheroe.loadUrl(superHeroe.urlImage)
        binding.labelNameSuperheroe.text = superHeroe.nameSuperHeroe
        binding.labelRealnameSuperheroe.text = superHeroe.realName
        binding.labelOccupationSuperheroe.text = superHeroe.occupation
    }

}