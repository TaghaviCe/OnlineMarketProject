package com.example.onlinemarketproject.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarketproject.model.*
import com.example.onlinemarketproject.network.Resource
import com.example.onlinemarketproject.repositories.UserRepository
import kotlinx.coroutines.launch
import java.io.IOException

class LoginViewModel (app: Application) : AndroidViewModel(app) {
    val successful : MutableLiveData<Boolean?> = MutableLiveData()
    val error : MutableLiveData<String?> = MutableLiveData()


    var sharedPreferences: SharedPreferences = app.getSharedPreferences("cartItemList", Context.MODE_PRIVATE)
    fun logiUser(username: String, password: String) {

        //create a demo user and upload
        val user = Login(username,password)
        viewModelScope.launch {
            try {

                val repo = UserRepository()
                repo.loginUser(user)
                val a = repo.loginMessageUser()
                when(a) {
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
                        saveUserAccessToken("${a.data?.token}")
                        Log.i("LoginViewModel","I dey here, Success ${a.data?.token}")
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