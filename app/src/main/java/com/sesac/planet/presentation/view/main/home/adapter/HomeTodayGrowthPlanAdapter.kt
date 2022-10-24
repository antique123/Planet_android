package com.sesac.planet.presentation.view.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemHomeTodayGrowthPlanBinding

class HomeTodayGrowthPlanAdapter(private val items: MutableList<String>, val isShowMore: Boolean) : RecyclerView.Adapter<HomeTodayGrowthPlanAdapter.HomeTodayGrowthPlanViewHolder>(){
    inner class HomeTodayGrowthPlanViewHolder(private val binding : ItemHomeTodayGrowthPlanBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.itemHomeTodayGrowthPlanTextView.text = items[position]
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeTodayGrowthPlanViewHolder {
        val binding = ItemHomeTodayGrowthPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeTodayGrowthPlanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeTodayGrowthPlanViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        var returnAmount: Int = 0
        if(isShowMore){
            returnAmount = items.size
        } else if(!isShowMore){
            returnAmount = 3
        }

        return returnAmount
    }
}