package com.example.onlinemarketproject.model


import com.squareup.moshi.Json

data class Image(
//    @Json(name = "alt")
//    val alt: String,
//    @Json(name = "date_created")
//    val dateCreated: String,
//    @Json(name = "date_created_gmt")
//    val dateCreatedGmt: String,
//    @Json(name = "date_modified")
//    val dateModified: String,
//    @Json(name = "date_modified_gmt")
//    val dateModifiedGmt: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "src")
    val src: String
)