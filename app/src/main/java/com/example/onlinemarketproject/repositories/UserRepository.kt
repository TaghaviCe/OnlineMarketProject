package com.example.onlinemarketproject.repositories


import android.util.Log
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

     suspend fun registerUser(user: Customer): Boolean? {
         Log.i("repo1","888")
         val d=ShopApi.retrofitService.registerUser(user)
         var yes:Boolean?=null
         if(d.code()==200){
             yes=true
             Log.i("repoOk","200")
         }
          return yes

    }

    fun registerMessage(): Resource<Customer>{
        Log.i("repo2","${a}")
       return responseToUserResult(a)
    }

     fun responseToUserResult(response : Response<Customer>) : Resource<Customer> {
        if (response.isSuccessful){
            response.body()?.let { result->
                Log.i("repo3","${a}")
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