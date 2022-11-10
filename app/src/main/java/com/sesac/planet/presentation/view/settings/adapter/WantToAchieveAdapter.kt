package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.R
import com.sesac.planet.databinding.ItemWantToAchieveBinding

class WantToAchieveAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<WantToAchieveAdapter.WantToAchieveViewHolder>() {
    private val checkedFlags = MutableList<Boolean>(items.size) { false }
    private val checkedItems = mutableListOf<String>()
    inner class WantToAchieveViewHolder(private val binding: ItemWantToAchieveBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.wantToAchieveItemTextView.text = items[position]

            binding.wantToAchieveItemTextView.setOnClickListener {
                if(!checkedFlags[position]) {
                    //아직 클릭 안됨
                    binding.wantToAchieveItemTextView.setBackgroundResource(R.drawable.shape_rectangle_radius_10dp_purple_solid)
                    binding.wantToAchieveItemTextView.setTextColor(binding.wantToAchieveItemTextView.resources.getColor(R.color.white, null))
                    checkedFlags[position] = true
                    checkedItems.add(items[position])
                } else {
                    //클릭 됨
                    binding.wantToAchieveItemTextView.setBackgroundResource(R.drawable.shape_rectangle_radius_10dp_gray_stroke_white_solid)
                    binding.wantToAchieveItemTextView.setTextColor(binding.wantToAchieveItemTextView.resources.getColor(R.color.gray_737373, null))
                    checkedFlags[position] = false
                    checkedItems.remove(items[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WantToAchieveViewHolder {
        val binding = ItemWantToAchieveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WantToAchieveViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WantToAchieveViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size

    fun getCheckedItems() = checkedItems
}