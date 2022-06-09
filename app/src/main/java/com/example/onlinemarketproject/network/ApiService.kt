package com.example.onlinemarketproject.network


import com.example.onlinemarketproject.model.Category
import com.example.onlinemarketproject.model.productItemX
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val apiParameter=ApiParameter()

    val retrofit= Retrofit.Builder()
     .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(apiParameter.BASE_URL)
        .client(client)
    .build()

//fun getRetrofitInstance(): Retrofit {
//    return Retrofit.Builder()
//        .baseUrl(apiParameter.BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//        .build()
//}
//val retrofitData = retrofit.loginUser(LoginRequest(amka,password))

//data class LoginRequest(
//    val amka: String, val password: String
//)

//data class LoginResponse(
//    @Json(name = "status")
//    val status: String,
//    @Json(name = "Token")
//    val token: String
//)
interface ApiService {
    @GET("products/")
    suspend fun listProductItems(
        @QueryMap options: Map<String, String> = apiParameter.getBase_OPTION()
    ): List<productItemX>

    @GET("products/{id}")
    suspend fun getProductItem(
        @Path("id") Id: Int,
        @QueryMap options: Map<String, String> = apiParameter.getBase_OPTION()
    ): productItemX

    @GET("products/")
    suspend fun getPopularItems(
        @QueryMap options: Map<String, String>
    ): List<productItemX>

    @GET("products/categories/")
    suspend fun getCategoryList(
        @QueryMap category: Map<String, String> = apiParameter.getCategory_OPTION()
        ): List<Category>
}
object ShopApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}


