package com.example.onlinemarketproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.databinding.ProdectRowItemsBinding
import com.example.onlinemarketproject.model.productItemX

class RecyclerViewCardAdapter() :
    ListAdapter<productItemX, RecyclerViewCardAdapter.MainViewHolder>(DiffCallback) {

    inner class MainViewHolder(private var binding: ProdectRowItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productItemX: productItemX) {
            binding.productImageSrc = productItemX.images?.get(0)?.src.toString()
            binding.productName = productItemX.name
            binding.price = productItemX.price
            binding.executePendingBindings()

        }

    }

    object DiffCallback : DiffUtil.ItemCallback<productItemX>() {
        override fun areItemsTheSame(oldItem: productItemX, newItem: productItemX): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: productItemX, newItem: productItemX): Boolean {
            return oldItem.id == newItem.id
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewCardAdapter.MainViewHolder {
        // var view=LayoutInflater.from(parent.context).inflate(R.layout.grid_view_item,parent,false)
        return MainViewHolder(ProdectRowItemsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: RecyclerViewCardAdapter.MainViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}



