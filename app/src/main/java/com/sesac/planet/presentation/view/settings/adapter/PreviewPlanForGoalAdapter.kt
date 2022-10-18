package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.R
import com.sesac.planet.databinding.ItemWantToAchieveBinding

class PreviewPlanForGoalAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<PreviewPlanForGoalAdapter.PreviewPlanForGoalViewHolder>() {

    inner class PreviewPlanForGoalViewHolder(private val binding: ItemWantToAchieveBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.wantToAchieveItemTextView.text = items[position]
            binding.wantToAchieveItemTextView.setBackgroundResource(R.drawable.shape_rectangle_radius_10dp_purple_solid)
            binding.wantToAchieveItemTextView.setTextColor(binding.wantToAchieveItemTextView.resources.getColor(R.color.white, null))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewPlanForGoalViewHolder {
        val binding = ItemWantToAchieveBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PreviewPlanForGoalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PreviewPlanForGoalViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size


}