package com.example.onlinemarketproject.model


import com.squareup.moshi.Json

data class Dimensions(
    @Json(name = "height")
    val height: String,
    @Json(name = "length")
    val length: String,
    @Json(name = "width")
    val width: String
)