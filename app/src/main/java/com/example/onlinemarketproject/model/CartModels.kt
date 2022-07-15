package com.example.onlinemarketproject.model

data class CartProduct(
    val id: Int,
    val images: List<Image>,
    val name: String,
    val price: String,
)
data class CartItem(val item: CartProduct, val quantity: Int)
