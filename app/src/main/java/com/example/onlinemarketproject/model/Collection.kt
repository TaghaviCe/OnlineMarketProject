package com.example.onlinemarketproject.model


import com.squareup.moshi.Json

data class Collection(
    @Json(name = "href")
    val href: String
)