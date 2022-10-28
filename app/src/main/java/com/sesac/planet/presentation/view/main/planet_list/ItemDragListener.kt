package com.sesac.planet.presentation.view.main.planet_list

import androidx.recyclerview.widget.RecyclerView

interface ItemDragListener {
    fun onStartDrag(viewHolder: RecyclerView.ViewHolder)
}