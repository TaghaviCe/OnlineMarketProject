package com.example.onlinemarketproject.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.model.Address
import com.example.onlinemarketproject.model.Customer
import com.example.onlinemarketproject.model.Geolocation
import com.example.onlinemarketproject.model.Name
import com.example.onlinemarketproject.network.Resource
import com.example.onlinemarketproject.repositories.UserRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class SignUpViewModel(app: Application) : AndroidViewModel(app) {

    val successful : MutableLiveData<Boolean?> = MutableLiveData()
    val error : MutableLiveData<String?> = MutableLiveData()
    var sharedPreferences:SharedPreferences = app.getSharedPreferences("cartItemList", Context.MODE_PRIVATE)
    fun registerUser(username: String, password: String) {

        //create a demo user and upload
        val user = Customer(address = Address(city = "new city", geolocation = Geolocation("10","10"), number = 3, street = "new street", zipcode = "new zipcode"), email = "new email", id = 10, name = Name(firstname = "new firstname", lastname = "new lastname"),password = password, phone = "new phone",username = username, v = 1)
        viewModelScope.launch {
            try {

                val repo = UserRepository()
                repo.registerUser(user)
                val a = repo.registerMessage()
                when(a){
                    is Resource.Loading -> {
                        Log.i("LoginViewModel","I dey here, Loading")
                    }
                    is Resource.Error -> {
                        error.postValue("${a.message}")
                        successful.postValue(false)
                        Log.i("LoginViewModel","I dey here, Error ${a.message}")
                    }
                    is Resource.Success -> {
                        successful.postValue(true)
                        saveUserAccessToken(username)
                        Log.i("LoginViewModel","I dey here, Success ${a.data.toString()}")
                    }
                }

            } catch (e: IOException) {
                Log.i("AuthUseCase", "${e.localizedMessage}")
//            emit (Resource.Error("Couldn't reach server. Check your internet connection."))
            }
        }

    }

    private fun saveUserAccessToken(username: String) {
        val edit=sharedPreferences.edit()
        edit.putString("token",username)
        edit.apply()
    }
}