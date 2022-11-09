package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.R
import com.sesac.planet.databinding.ItemMyFutureLookBinding

class MyFutureLookAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<MyFutureLookAdapter.MyFutureLookViewHolder>() {
    private val checkedFlags = MutableList(items.size) { false }
    private val checkedItems = mutableListOf<String>()
    inner class MyFutureLookViewHolder(private val binding: ItemMyFutureLookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.descriptionTextView.text = items[position]
            binding.descriptionTextView.setOnClickListener {
                updateView(position, binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFutureLookViewHolder {
        val binding = ItemMyFutureLookBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyFutureLookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyFutureLookViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size

    private fun updateView(position: Int, binding: ItemMyFutureLookBinding) {
        if(!checkedFlags[position]) {
            binding.descriptionTextView.setBackgroundResource(R.drawable.shape_rectangle_purple_stroke_white_solid)
            binding.descriptionTextView.setTextColor(binding.descriptionTextView.resources.getColor(R.color.purple_896DF3, null))
            checkedFlags[position] = true
            checkedItems.add(items[position])
        } else {
            binding.descriptionTextView.setBackgroundResource(R.drawable.shape_rectangle_gray_stroke_white_solid)
            binding.descriptionTextView.setTextColor(binding.descriptionTextView.resources.getColor(R.color.gray_737373, null))
            checkedFlags[position] = false
            checkedItems.remove(items[position])
        }
    }

    fun getCheckedItems() = checkedItems
}