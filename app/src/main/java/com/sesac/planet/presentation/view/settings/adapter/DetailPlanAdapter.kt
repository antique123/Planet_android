package com.sesac.planet.presentation.view.settings.adapter

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemDetailPlanBinding

class DetailPlanAdapter : RecyclerView.Adapter<DetailPlanAdapter.DetailPlanViewHolder>() {
    private val items = mutableListOf<String>()
    lateinit var addDetails: (String, String, Int) -> Unit
    var key: String = ""
    inner class DetailPlanViewHolder(private val binding: ItemDetailPlanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            //binding.detailPlanEditText.hint = items[position]
            binding.detailPlanEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    //Log.d("detailTest", "$key $position ${binding.detailPlanEditText.text}")
                    addDetails(key, binding.detailPlanEditText.text.toString(), position)
                }

                override fun afterTextChanged(s: Editable?) {
                }

            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailPlanViewHolder {
        val binding = ItemDetailPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DetailPlanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailPlanViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = items.size

    fun addDetailPlan(position: Int, plan: String) {
        items.add(plan)
        notifyItemInserted(items.lastIndex)
    }
}