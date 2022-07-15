package com.example.onlinemarketproject.model

import com.squareup.moshi.Json

data class orderItem(
    @Json(name = "name") val productName: String,
    val product_id: Int,
    var quantity: Int = 1,
    val price: String,
    val image: List<Image>?
)
