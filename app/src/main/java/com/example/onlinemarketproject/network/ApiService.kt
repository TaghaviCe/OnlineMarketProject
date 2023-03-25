package com.example.onlinemarketproject.network


import com.example.onlinemarketproject.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

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

interface ApiService {
    @GET("products")
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

    @GET("products/categories")
    suspend fun getCategoryList(
        @QueryMap category: Map<String, String> = apiParameter.getCategory_OPTION()
        ): List<Category>

    @GET("products/category/{category}")
    suspend fun getCategoryProducts(
        @Path("category") category: String,
        @QueryMap options: Map<String, String> = apiParameter.getCategory_OPTION()
    ) : List<productItemX>

    @GET("products")
    suspend fun getProductsOfCategory(
        @QueryMap option:Map<String, String>

    ):List<productItemX>

    @GET("users/{id}")
    suspend fun getUser(@Path(value = "id") id : Int) : Response<Customer>
    //Login user
    @POST("auth/login")
    suspend fun loginUser(@Body login : Login): Response<LoginResponse>

    //Register user
    @POST("users")
    suspend fun registerUser(
        @Body user :Customer): Response<Customer>

}
object ShopApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}


