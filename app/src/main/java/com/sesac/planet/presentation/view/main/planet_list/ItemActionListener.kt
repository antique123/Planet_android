package com.sesac.planet.presentation.view.main.planet_list

interface ItemActionListener {
    fun onItemMoved(from: Int, to: Int)
    fun onItemSwiped(position: Int)
}