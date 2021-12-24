package com.example.studyplanner.ui.plan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.studyplanner.database.PlanInput
import com.example.studyplanner.databinding.RowLayoutBinding


class PlanAdapter (val clickListener: PlanClickListener): ListAdapter<PlanInput, PlanAdapter.ViewHolder>(PlanDiffCallBack){

    companion object PlanDiffCallBack : DiffUtil.ItemCallback<PlanInput>(){
        override fun areItemsTheSame(oldItem: PlanInput, newItem: PlanInput) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: PlanInput, newItem: PlanInput) = oldItem == newItem
    }
    class ViewHolder (val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(planInput: PlanInput, clickListener: PlanClickListener){
            binding.planInput = planInput
            binding.clicklistener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, clickListener)
    }

    class PlanClickListener(val clickListener: (planInput: PlanInput) -> Unit){
        fun onClick(planInput: PlanInput) = clickListener(planInput)
    }
}




