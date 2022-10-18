package com.sesac.planet.presentation.view.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesac.planet.databinding.ItemPlanForGoalBinding

class PlanForGoalAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<PlanForGoalAdapter.PlanForGoalViewHolder>(){

    inner class PlanForGoalViewHolder(private val binding: ItemPlanForGoalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.planTitleTextView.text = items[position]
            binding.addDetailPlanButton.setOnClickListener {
                binding.detailPlanRecyclerView.adapter?.let { adapter ->
                    (adapter as DetailPlanAdapter).addDetailPlan("동적 추가 테스트")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanForGoalViewHolder {
        val binding = ItemPlanForGoalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.detailPlanRecyclerView.layoutManager = LinearLayoutManager(parent.context)
        binding.detailPlanRecyclerView.adapter = DetailPlanAdapter()

        return PlanForGoalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanForGoalViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = items.size


}