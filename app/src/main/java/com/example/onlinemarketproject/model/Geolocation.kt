package com.example.onlinemarketproject.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Geolocation(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("long")
    val long: String
)
