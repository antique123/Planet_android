package com.sesac.planet.presentation.view.settings.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.data.model.ResultPlanetInfo
import com.sesac.planet.databinding.ItemDialogAddToDoPlanetBinding
import com.sesac.planet.presentation.view.settings.OnSelectPlanetResult

class DialogSelectAdapter(val items: List<ResultPlanetInfo>?, private val onSelectPlanet: OnSelectPlanetResult) :
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
        holder.itemView.setOnClickListener {
            //binding.itemDialogPlanetImg.setImageResource()
            onSelectPlanet.onItemClickResult(items?.get(position)?.planet_id)
        }
    }

    override fun getItemCount(): Int = items!!.size

    inner class ViewHolder(private val binding: ItemDialogAddToDoPlanetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.itemDialogPlanetTv.text = items!![position].planet_name
            Log.d("색깔 : ", "${items!![position].color}")
            if(items!![position].color?.contains("#") == true){
                //binding.itemDialogPlanetImg.setColorFilter(Color.parseColor(items!![position].color))
            } else {
                binding.itemDialogPlanetImg.setColorFilter(Color.parseColor("#E1E1E1"))
            }
        }
    }


}