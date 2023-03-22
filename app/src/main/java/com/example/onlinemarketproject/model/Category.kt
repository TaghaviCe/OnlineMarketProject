package com.example.onlinemarketproject.model


import com.squareup.moshi.Json

data class Category(
    @Json(name="id")
    var id : Int,
    @Json(name="category")
    var category : String
    )
