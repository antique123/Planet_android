package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemPlanDetailBinding

class PlanDetailAdapter(private val items :  MutableList<String>) : RecyclerView.Adapter<PlanDetailAdapter.PlanDetailViewHolder>(){
    inner class PlanDetailViewHolder(private val binding : ItemPlanDetailBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.planDetailTextView.text = items[position]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanDetailViewHolder {
        val binding = ItemPlanDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanDetailViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size
}