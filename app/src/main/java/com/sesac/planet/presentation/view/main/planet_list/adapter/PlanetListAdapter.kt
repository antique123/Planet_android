package com.sesac.planet.presentation.view.main.planet_list.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.data.model.PlanetListData
import com.sesac.planet.data.model.ResultPlanetInfo
import com.sesac.planet.databinding.ItemPlanetListBinding

class PlanetListAdapter(val items: ArrayList<PlanetListData>) : RecyclerView.Adapter<PlanetListAdapter.PlanetListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetListViewHolder {
        val binding = ItemPlanetListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanetListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetListViewHolder, position: Int) {
        holder.bind(position)
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount() = items.size

    inner class PlanetListViewHolder(private val binding : ItemPlanetListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.itemPlanetListImg.setImageResource(items[position].planetImg)
            binding.itemPlanetListPlanetTextView.text = items[position].planetName
            binding.itemPlanetListExplainPlanetTextView.text = items[position].planetContent
            binding.itemPlanetListLevelTextView.text = "LV.${items[position].planetLevel}"
            binding.itemPlanetListLevelProgressBar.progress = items[position].planetExp
        }
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener: OnItemClickListener
}