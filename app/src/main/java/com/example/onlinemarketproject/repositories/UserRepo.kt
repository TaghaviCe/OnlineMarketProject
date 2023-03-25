package com.example.onlinemarketproject.repositories

import com.example.onlinemarketproject.model.Customer
import com.example.onlinemarketproject.model.Login
import com.example.onlinemarketproject.model.LoginResponse
import com.example.onlinemarketproject.network.Resource

interface UserRepo {
    suspend fun loginUser(login: Login) : Resource<LoginResponse>
    suspend fun registerUser(user : Customer) : Resource<Customer>
}