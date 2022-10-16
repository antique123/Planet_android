package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemTodayPlanBinding

class TodayPlanAdapter(private val items : MutableList<String>, val isTodayPlan : Boolean) : RecyclerView.Adapter<TodayPlanAdapter.TodayPlanViewHolder>(){
    inner class TodayPlanViewHolder(private val binding : ItemTodayPlanBinding) : RecyclerView.ViewHolder(binding.root){
       fun bind(position : Int){
           binding.itemTodayPlanTextView.text = items[position]
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayPlanViewHolder {
        val binding = ItemTodayPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodayPlanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodayPlanViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        var returnSize : Int = 3

        if(isTodayPlan){
            returnSize = items.size
        } else if(!isTodayPlan){
            returnSize = 3
        }
        return returnSize
    }
}