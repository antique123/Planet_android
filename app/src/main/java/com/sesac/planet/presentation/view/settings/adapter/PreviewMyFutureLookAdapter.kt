package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.R
import com.sesac.planet.databinding.ItemPreviewMyFutureLookBinding

class PreviewMyFutureLookAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<PreviewMyFutureLookAdapter.PreviewMyFutureLookViewHolder>() {

    inner class PreviewMyFutureLookViewHolder(private val binding: ItemPreviewMyFutureLookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.descriptionTextView.text = items[position]
            binding.descriptionTextView.setBackgroundResource(R.drawable.shape_rectangle_purple_stroke_white_solid)
            binding.descriptionTextView.setTextColor(binding.descriptionTextView.resources.getColor(R.color.purple_896DF3, null))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewMyFutureLookViewHolder {
        val binding = ItemPreviewMyFutureLookBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PreviewMyFutureLookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PreviewMyFutureLookViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size
}