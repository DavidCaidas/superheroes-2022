package com.iesam.superhero.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iesam.app.extensions.loadUrl
import com.iesam.superhero.domain.GetSuperHeroDetailUseCase
import com.iesam.superheroe.databinding.ViewItemSuperheroDetailBinding

class SuperHeroDetailViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(urlImage: String) {
        val binding = ViewItemSuperheroDetailBinding.bind(view)
        binding.imageSuperhero.loadUrl(urlImage)
    }
}