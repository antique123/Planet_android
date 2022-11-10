package com.sesac.planet.presentation.view.settings.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.data.model.ResultPlanetInfo
import com.sesac.planet.databinding.ItemDialogAddToDoPlanetBinding
import com.sesac.planet.presentation.view.settings.OnSelectPlanetResult

class DialogSelectAdapter(val items: List<ResultPlanetInfo>?, private val onSelectPlanet: OnSelectPlanetResult) :
    RecyclerView.Adapter<DialogSelectAdapter.ViewHolder>() {
    private lateinit var binding: ItemDialogAddToDoPlanetBinding

    private var mSelectedItem = -1

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
        holder.itemView.setOnClickListener {
            val currentPosition = holder.adapterPosition

            if(mSelectedItem == currentPosition){
                mSelectedItem = -1
                binding.itemDialogPlanetCbx.isChecked = false
            } else {
                if(mSelectedItem >= 0){
                    binding.itemDialogPlanetCbx.isChecked = false
                }

                mSelectedItem = currentPosition
                binding.itemDialogPlanetCbx.isChecked = true
            }

            onSelectPlanet.onItemClickResult(items!![position].planet_id)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = items!!.size

    inner class ViewHolder(private val binding: ItemDialogAddToDoPlanetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.itemDialogPlanetTv.text = items!![position].planet_name
        }
    }


}