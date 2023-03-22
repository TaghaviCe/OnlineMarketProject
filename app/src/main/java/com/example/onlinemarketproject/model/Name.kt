package com.example.onlinemarketproject.model

import com.squareup.moshi.Json

data class Name(

@Json(name="firstname")
val firstname: String,
@Json(name="lastname")
val lastname: String

)
