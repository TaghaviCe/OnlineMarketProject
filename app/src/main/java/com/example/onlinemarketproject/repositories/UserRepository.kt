package com.example.onlinemarketproject.repositories


import com.example.onlinemarketproject.model.Customer
import com.example.onlinemarketproject.model.Login
import com.example.onlinemarketproject.model.LoginResponse
import com.example.onlinemarketproject.network.Resource
import com.example.onlinemarketproject.network.ShopApi
import retrofit2.Response

class UserRepository {
lateinit var a:Response<Customer>
lateinit var b:Response<LoginResponse>

     suspend fun loginUser(login: Login): Response<LoginResponse> {
         b=ShopApi.retrofitService.loginUser(login)
         return b
    }
    fun loginMessageUser(): Resource<LoginResponse> {
        return responseToString(b)
    }

     suspend fun registerUser(user: Customer): Response<Customer> {
          a=ShopApi.retrofitService.registerUser(user)
          return a
    }

    fun registerMessage(): Resource<Customer>{
       return responseToUserResult(a)
    }

     fun responseToUserResult(response : Response<Customer>) : Resource<Customer> {
        if (response.isSuccessful){
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }


    private fun responseToString(response: Response<LoginResponse>) : Resource<LoginResponse>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }
}