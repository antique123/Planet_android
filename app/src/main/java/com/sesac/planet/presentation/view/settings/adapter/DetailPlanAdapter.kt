package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemDetailPlanBinding

class DetailPlanAdapter : RecyclerView.Adapter<DetailPlanAdapter.DetailPlanViewHolder>() {
    private val items = mutableListOf<String>()

    inner class DetailPlanViewHolder(private val binding: ItemDetailPlanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.detailPlanTextView.text = items[position]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailPlanViewHolder {
        val binding = ItemDetailPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DetailPlanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailPlanViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size

    fun addDetailPlan(plan: String) {
        items.add(plan)
        notifyItemInserted(items.lastIndex)
    }
}