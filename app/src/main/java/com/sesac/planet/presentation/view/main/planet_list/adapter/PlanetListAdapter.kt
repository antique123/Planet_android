package com.sesac.planet.presentation.view.main.planet_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.data.model.ResultPlanetInfo
import com.sesac.planet.databinding.ItemPlanetListBinding

class PlanetListAdapter(val items: List<ResultPlanetInfo>?) : RecyclerView.Adapter<PlanetListAdapter.PlanetListViewHolder>(){

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

    override fun getItemCount() = items!!.size

    inner class PlanetListViewHolder(private val binding : ItemPlanetListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.itemPlanetListPlanetTextView.text = items!![position].planet_name
            binding.itemPlanetListExplainPlanetTextView.text = items!![position].planet_intro
            binding.itemPlanetListLevelTextView.text = "LV.${items!![position].planet_level}"
            binding.itemPlanetListLevelProgressBar.progress = items!![position].planet_exp
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