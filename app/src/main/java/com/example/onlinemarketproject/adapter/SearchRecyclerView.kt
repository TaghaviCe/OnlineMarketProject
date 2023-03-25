package com.example.onlinemarketproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.databinding.ProdectRowItemsBinding
import com.example.onlinemarketproject.model.productItemX

class SearchRecyclerView:
    ListAdapter<productItemX, SearchRecyclerView.MainViewHolder>(DiffCallback) {

    class MainViewHolder( private var binding: ProdectRowItemsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(productItemX: productItemX) {
            binding.productImageSrc= productItemX.image
            binding.productName=productItemX.title
            binding.price=productItemX.price.toString()
            binding.executePendingBindings()

        }

    }

    object DiffCallback: DiffUtil.ItemCallback<productItemX>() {
        override fun areItemsTheSame(oldItem: productItemX, newItem: productItemX): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: productItemX, newItem: productItemX): Boolean {
            return oldItem.id==newItem.id
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecyclerView.MainViewHolder {
        // var view=LayoutInflater.from(parent.context).inflate(R.layout.grid_view_item,parent,false)
        return MainViewHolder(ProdectRowItemsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SearchRecyclerView.MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}