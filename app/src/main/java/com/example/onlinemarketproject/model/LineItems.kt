package com.example.onlinemarketproject.model

import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LineItems(
    @PrimaryKey(autoGenerate = false)
    @Json(name = "id")
    val id: Int,
    @Json(name="image")
    val image: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "quantity")
    var quantity: Int,
    @Json(name = "pricePerItem")
    val pricePerItem: Double,
)
