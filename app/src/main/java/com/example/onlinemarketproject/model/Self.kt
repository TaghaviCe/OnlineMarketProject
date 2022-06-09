package com.example.onlinemarketproject.model


import com.squareup.moshi.Json

data class Self(
    @Json(name = "href")
    val href: String
)