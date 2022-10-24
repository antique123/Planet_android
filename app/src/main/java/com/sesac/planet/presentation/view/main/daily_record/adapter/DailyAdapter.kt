package com.sesac.planet.presentation.view.main.daily_record.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sesac.planet.databinding.ItemRecordDailyBinding

class DailyAdapter : RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {
    private val items = mutableListOf<String>()
    inner class DailyViewHolder(private val binding: ItemRecordDailyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            Glide.with(binding.dailyImageView.context)
                .load(items[position])
                .into(binding.dailyImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val binding = ItemRecordDailyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DailyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size

    fun setItems(items: MutableList<String>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}