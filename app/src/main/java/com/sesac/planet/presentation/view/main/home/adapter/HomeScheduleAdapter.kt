package com.sesac.planet.presentation.view.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemHomeTodayScheduleBinding

class HomeScheduleAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<HomeScheduleAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeTodayScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemHomeTodayScheduleBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.itemHomeScheduleTv.text = items[position]
        }
    }

}