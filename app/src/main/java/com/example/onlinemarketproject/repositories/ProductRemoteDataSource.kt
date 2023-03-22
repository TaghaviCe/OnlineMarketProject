package com.example.onlinemarketproject.repositories

import com.example.onlinemarketproject.model.Customer
import com.example.onlinemarketproject.model.Login
import com.example.onlinemarketproject.model.LoginResponse
import retrofit2.Response

interface ProductRemoteDataSource {
    suspend fun getUser(id : Int) : Response<Customer>
    suspend fun updateUser(id : Int,user: Customer) : Response<Customer>
    suspend fun loginUser(login : Login): Response<LoginResponse>
    suspend fun registerUser(user: Customer) : Response<Customer>
}