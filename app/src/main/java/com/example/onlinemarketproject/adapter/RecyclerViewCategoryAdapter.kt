package com.example.onlinemarketproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinemarketproject.databinding.CategoryRowItemsBinding
import com.example.onlinemarketproject.model.Category
import com.example.onlinemarketproject.model.productItemX

typealias showProduct= (Int) -> Unit
class RecyclerViewCategoryAdapter(var onProductListClick: showProduct) :
    ListAdapter<Category, RecyclerViewCategoryAdapter.MainViewHolder>(DiffCallback) {

    inner class MainViewHolder( private var binding: CategoryRowItemsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(category:Category) {
            binding.productImageSrc= category.id.toString()
            binding.productName=category.category.toString()
            binding.executePendingBindings()
            binding.root.setOnClickListener { onProductListClick(category.id) }
        }

    }

    object DiffCallback: DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id==newItem.id
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewCategoryAdapter.MainViewHolder {
        // var view=LayoutInflater.from(parent.context).inflate(R.layout.grid_view_item,parent,false)
        return MainViewHolder(CategoryRowItemsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerViewCategoryAdapter.MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

