package com.iesam.superhero.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iesam.superhero.domain.GetSuperHeroFeedUseCase
import com.iesam.superheroe.R

class SuperHeroAdapter : RecyclerView.Adapter<SuperHeroViewHolder>() {

    private val dataItems = mutableListOf<GetSuperHeroFeedUseCase.SuperHeroFeed>()

    fun setDataItems(superHeros: List<GetSuperHeroFeedUseCase.SuperHeroFeed>) {
        dataItems.clear()
        dataItems.addAll(superHeros)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_superheroe_feed, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(dataItems[position])
    }

    override fun getItemCount(): Int = dataItems.size
}