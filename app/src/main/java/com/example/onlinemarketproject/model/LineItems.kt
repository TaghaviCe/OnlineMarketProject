package com.example.onlinemarketproject.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LineItems(
    @Json(name = "id")
    val id: Int = 0 ,
    @Json(name = "name")
    val name: String,
    @Json(name = "product_id")
    val productId: Int,
//    @Json(name = "variation_id")
//    val variationId: Int,
    @Json(name = "quantity")
    var quantity: Int,
//    @Json(name = "sku")
//    val sku: String,
    @Json(name = "price")
    val price: String
)
