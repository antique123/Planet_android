package com.sesac.planet.presentation.view.main.daily_record.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.sesac.planet.R
import com.sesac.planet.databinding.ItemGalleryBinding

class GalleryAdapter(private val context: Context) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {
    private val imageUriList: MutableList<String> = mutableListOf()
    private var selectedPosition: Int = -1
    private var selectedImageUri: String = ""

    inner class GalleryViewHolder(private val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int ){
            if(selectedPosition == position) {
                binding.root.setBackgroundColor(ContextCompat.getColor(context, R.color.orange))
            } else {
                binding.root.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
            }

            binding.root.setOnClickListener {
                if(selectedPosition == -1) {
                    selectedPosition = position
                    selectedImageUri = imageUriList[position]
                    binding.root.setBackgroundColor( ContextCompat.getColor(context, R.color.orange))
                } else {
                    if(selectedPosition == position) {
                        selectedPosition = -1
                        selectedImageUri = ""
                        binding.root.setBackgroundColor( ContextCompat.getColor(context, R.color.white))

                    } else{
                        Snackbar.make(binding.root, "하나의 이미지만 선택할 수 있습니다.", Snackbar.LENGTH_LONG).show()

                    }
                }

            }

            Glide.with(binding.imageView.context)
                .load(imageUriList[position])
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = imageUriList.size

    fun setImageUris(imageUris: MutableList<String>) {
        imageUriList.addAll(imageUris)
        notifyDataSetChanged()
    }

    fun getSelectedImage() = selectedImageUri
}