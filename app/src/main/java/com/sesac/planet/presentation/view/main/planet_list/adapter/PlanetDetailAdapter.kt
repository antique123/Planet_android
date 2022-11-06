package com.sesac.planet.presentation.view.main.planet_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemPlanetDetailDetailsPlanBinding

class PlanetDetailAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<PlanetDetailAdapter.PlanetDetailViewHolder>() {
    inner class PlanetDetailViewHolder(private val binding: ItemPlanetDetailDetailsPlanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.itemPlanetDetailToDoTextView.text = items[position]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetDetailViewHolder {
        val binding = ItemPlanetDetailDetailsPlanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlanetDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetDetailViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size
}