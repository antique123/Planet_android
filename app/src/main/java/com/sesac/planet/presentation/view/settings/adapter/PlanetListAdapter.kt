package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemPlanetListBinding

class PlanetListAdapter(private val items :  MutableList<String>) : RecyclerView.Adapter<PlanetListAdapter.PlanetListViewHolder>(){
    inner class PlanetListViewHolder(private val binding : ItemPlanetListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.itemPlanetListPurposeTextView.text = items[position]
        }
    }

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

    interface ItemClickListener{
        fun onClick(view:View, position: Int)
    }

    private lateinit var itemClickListener : ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }
}