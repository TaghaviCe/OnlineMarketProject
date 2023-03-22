package com.example.onlinemarketproject.model

import com.squareup.moshi.Json

data class Rating(
    @Json(name="count")
    val count: Int,
    @Json(name="rate")
    val rate: Double
)