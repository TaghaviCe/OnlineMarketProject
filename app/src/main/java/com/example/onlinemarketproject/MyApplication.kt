package com.example.onlinemarketproject
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.onlinemarketproject.data.myPreference


class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        setupPreferences()
    }
    private fun setupPreferences() {
       // myPreference.init(this)
    }


}