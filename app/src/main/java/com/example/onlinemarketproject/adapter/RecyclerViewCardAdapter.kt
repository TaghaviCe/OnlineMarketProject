package com.example.onlinemarketproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.databinding.CartRowItemsBinding
import com.example.onlinemarketproject.databinding.ProdectRowItemsBinding
import com.example.onlinemarketproject.model.LineItems
import com.example.onlinemarketproject.model.orderItem
import com.example.onlinemarketproject.model.productItemX
import com.example.onlinemarketproject.repositories.ProductRepository

class RecyclerViewCardAdapter() :
    ListAdapter<LineItems, RecyclerViewCardAdapter.MainViewHolder>(DiffCallback) {

    inner class MainViewHolder(private var binding: CartRowItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var productRepository=ProductRepository()
        fun bind(lineItems: LineItems) {
              binding.productName=lineItems.name
              binding.productPrice=lineItems.price.toString()
//            binding.productImageSrc = productItemX.images?.get(0)?.src.toString()
//            binding.productName = productItemX.name
//            binding.price = productItemX.price
            binding.executePendingBindings()

        }

    }

    object DiffCallback : DiffUtil.ItemCallback<LineItems>() {
        override fun areItemsTheSame(oldItem: LineItems, newItem: LineItems): Boolean {
            return oldItem.productId == newItem.productId
        }

        override fun areContentsTheSame(oldItem: LineItems,newItem: LineItems): Boolean {
            return oldItem.productId == newItem.productId
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewCardAdapter.MainViewHolder {
        // var view=LayoutInflater.from(parent.context).inflate(R.layout.grid_view_item,parent,false)
        return MainViewHolder(CartRowItemsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: RecyclerViewCardAdapter.MainViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}



