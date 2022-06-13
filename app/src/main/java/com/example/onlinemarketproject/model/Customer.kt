package com.example.onlinemarketproject.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Customer(
    @Json(name="id")
     var mId: Int? = null,

    @Json(name="email")
     val mEmail: String? = null,

  @Json(name="first_name")
    val mFirstName: String? = null,

  @Json(name="last_name")
   val mLastName: String? = null,

   @Json(name="username")
   val mUserName: String? = null
//
//   @Json(name="billing")
//    val mBilling: Billing? = null,
//
//   @Json(name="shipping")
//   val mShipping: Shipping? = null,

)
