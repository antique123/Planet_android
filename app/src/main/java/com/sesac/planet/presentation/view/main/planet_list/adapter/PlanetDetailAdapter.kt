package com.sesac.planet.presentation.view.main.planet_list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemPlanetDetailDetailsPlanBinding
import com.sesac.planet.presentation.view.main.planet_list.ItemActionListener
import com.sesac.planet.presentation.view.main.planet_list.ItemDragListener

class PlanetDetailAdapter(
    private val items: MutableList<String>,
    private val listener: ItemDragListener
) : RecyclerView.Adapter<PlanetDetailAdapter.PlanDetailViewHolder>(), ItemActionListener {
    @SuppressLint("ClickableViewAccessibility")
    inner class PlanDetailViewHolder(
        private val binding: ItemPlanetDetailDetailsPlanBinding,
        listener: ItemDragListener
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.itemPlanetDetailDragImageView.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    listener.onStartDrag(this)
                }
                false
            }

            binding.itemPlanetDetailDeleteImageView.setOnClickListener {
                val position:Int = adapterPosition
                if(position!=RecyclerView.NO_POSITION){
                    if(itemClickListener!=null){
                        itemClickListener.onDeleteClick(it, position)
                    }
                }
            }
        }

        fun bind(position: Int) {
            binding.itemPlanetDetailToDoTextView.text = items[position]
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanDetailViewHolder {
        val binding = ItemPlanetDetailDetailsPlanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlanDetailViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PlanDetailViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size

    interface OnItemClickListener{
        fun onDeleteClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener: OnItemClickListener

    override fun onItemMoved(from: Int, to: Int) {
        if (from == to) {
            return
        }

        val fromItem = items.removeAt(from)
        items.add(to, fromItem)
        notifyItemMoved(from, to)
    }

    override fun onItemSwiped(position: Int) {
    }
}