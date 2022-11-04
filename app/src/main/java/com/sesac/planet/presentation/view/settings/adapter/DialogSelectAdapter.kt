package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.R
import com.sesac.planet.databinding.ItemDialogAddToDoPlanetBinding

class DialogSelectAdapter(private val items: MutableList<String>) :
    RecyclerView.Adapter<DialogSelectAdapter.ViewHolder>() {
    private lateinit var binding: ItemDialogAddToDoPlanetBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemDialogAddToDoPlanetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

        binding.root.setOnClickListener {
            binding.itemDialogPlanetImg.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemDialogAddToDoPlanetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.itemDialogPlanetTv.text = items[position]

        }
    }

}