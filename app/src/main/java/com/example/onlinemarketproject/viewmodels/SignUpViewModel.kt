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

    var successful : MutableLiveData<Boolean?> = MutableLiveData()
    val error : MutableLiveData<String?> = MutableLiveData()
    var sharedPreferences:SharedPreferences = app.getSharedPreferences("cartItemList", Context.MODE_PRIVATE)
    fun registerUser(username: String, password: String) {
        Log.i("Sign Up ViewModel","go ")
        //create a demo user and upload
        val user = Customer(address = Address(city = "new city", geolocation = Geolocation("10","10"), number = 3, street = "new street", zipcode = "new zipcode"), email = "new email", id = 10, name = Name(firstname = "new firstname", lastname = "new lastname"),password = password, phone = "new phone",username = username, v = 1)
        viewModelScope.launch {
            try {
                val repo = UserRepository()
                Log.i("Sign Up ViewModel","go 2 ")
                val a= repo.registerUser(user)
                 if(a==true){
                     Log.i("Sign Up ViewModel","go 3 ")
                 }else{
                     Log.i("Sign Up ViewModel","go 4 ")
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