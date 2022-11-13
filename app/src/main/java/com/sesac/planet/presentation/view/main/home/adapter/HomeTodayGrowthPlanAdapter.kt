package com.sesac.planet.presentation.view.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.R
import com.sesac.planet.data.model.plan.ResultTodayGrowthPlans
import com.sesac.planet.databinding.ItemHomeTodayGrowthPlanBinding

class HomeTodayGrowthPlanAdapter(val items: List<ResultTodayGrowthPlans>?, private val isShowMore: Boolean) : RecyclerView.Adapter<HomeTodayGrowthPlanAdapter.HomeTodayGrowthPlanViewHolder>(){
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
        return when(isShowMore){
            true -> items!!.size
            false -> 3
        }
    }

    inner class HomeTodayGrowthPlanViewHolder(private val binding : ItemHomeTodayGrowthPlanBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.itemHomeTodayGrowthPlanTextView.text = items!![position].plan_content

            when(items!![position].color){
                "#896DF3" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_purple)
                "#7AE3AA" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_mint)
                "#FFC212" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_mustard)
                "#F8CBB6" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_pink)
                "#F2606A" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_hotpink)
                "#E0DFFE" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_navy)
                "#D3FB03" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_lime)
                "#FDFE00" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_lemon)
                "#B4C9FF" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_sora)
                "#E1E1E1" -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_mono)
                else -> binding.itemHomeTodayGrowthPlanImageView.setImageResource(R.drawable.ic_planet_basic)
            }

        }
    }

}