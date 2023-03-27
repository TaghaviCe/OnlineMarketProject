package com.example.onlinemarketproject.model


import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class productItemX(

    @Json(name = "category")
    val category: String,
    @Json(name="description")
    val description: String,
    @PrimaryKey(autoGenerate = false)
    @Json(name="id")
    val id: Int,
    @Json(name="image")
    val image: String,
    @Json(name="price")
    val price: Double,
    @Json(name= "rating")
    val rating: Rating,
    @Json(name="title")
    val title: String

)