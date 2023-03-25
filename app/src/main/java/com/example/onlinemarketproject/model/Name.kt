package com.example.onlinemarketproject.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Name(
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String
)
