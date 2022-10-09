package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemPlanetListBinding

class PlanetListAdapter(private val items :  MutableList<String>) : RecyclerView.Adapter<PlanetListAdapter.PlanetListViewHolder>(){
    inner class PlanetListViewHolder(private val binding : ItemPlanetListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.planetListPurposeTextView.text = items[position]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetListViewHolder {
        val binding = ItemPlanetListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanetListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetListViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size
}