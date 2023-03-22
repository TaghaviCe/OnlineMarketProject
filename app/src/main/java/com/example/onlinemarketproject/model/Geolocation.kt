package com.example.onlinemarketproject.model

import com.squareup.moshi.Json

data class Geolocation(
    @Json(name="lat")
    val lat: String,
    @Json(name="long")
    val long: String
)
