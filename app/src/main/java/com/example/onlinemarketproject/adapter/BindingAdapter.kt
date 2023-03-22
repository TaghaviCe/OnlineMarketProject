package com.example.onlinemarketproject.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.bumptech.glide.Glide

import com.example.onlinemarketproject.model.Category
import com.example.onlinemarketproject.model.LineItems
import com.example.onlinemarketproject.model.orderItem
import com.example.onlinemarketproject.model.productItemX



@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<productItemX>?) {
    val adapter = recyclerView.adapter as RecyclerViewProductAdapter
    adapter.submitList(data)
}
@BindingAdapter("listCartData")
fun bindRecyclerViewCart(recyclerView: RecyclerView, data: List<LineItems>?) {
    val adapter = recyclerView.adapter as RecyclerViewCardAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataExpensive")
fun bindRecyclerViewExpensive(recyclerView: RecyclerView, data: List<productItemX>?) {
    val adapter = recyclerView.adapter as RecyclerViewProductAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataCheap")
fun bindRecyclerViewCheap(recyclerView: RecyclerView, data: List<productItemX>?) {
    val adapter = recyclerView.adapter as RecyclerViewProductAdapter
    adapter.submitList(data)
}


@BindingAdapter("listDataPopular")
fun bindRecyclerViewPopular(recyclerView: RecyclerView, data: List<productItemX>?) {
    val adapter = recyclerView.adapter as RecyclerViewProductAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataRecent")
fun bindRecyclerViewrecent(recyclerView: RecyclerView, data: List<productItemX>?) {
    val adapter = recyclerView.adapter as RecyclerViewProductAdapter
    adapter.submitList(data)
}
@BindingAdapter("listDataTop")
fun bindRecyclerViewTop(recyclerView: RecyclerView, data: List<productItemX>?) {
    val adapter = recyclerView.adapter as RecyclerViewProductAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataWoman")
fun bindRecyclerViewWoman(recyclerView: RecyclerView, data: List<productItemX>?) {
    val adapter = recyclerView.adapter as RecyclerViewProductAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataCategory")
fun bindRecyclerViewCategory(recyclerView: RecyclerView, data: List<Category>?) {
    val adapter = recyclerView.adapter as RecyclerViewCategoryAdapter
    adapter.submitList(data)
}



/**
 * Uses the Coil library to load an image by URL into an [ImageView]
 */

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView)
            .load("$imgUrl")
            .override(400,400)
            .centerCrop()
            .placeholder(android.R.drawable.progress_indeterminate_horizontal)
            .error(android.R.drawable.stat_notify_error)
            .into(imgView)
   }
}
