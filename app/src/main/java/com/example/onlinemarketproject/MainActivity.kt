package com.example.onlinemarketproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //splash screen
        supportActionBar?.hide()
        val imageView = findViewById<ImageView>(R.id.splash_screen)
        val fragment = findViewById<View>(R.id.fragmentContainerView)
        imageView.alpha=0f
        imageView.animate().setDuration(1500).alpha(1f).withEndAction {
            fragment.visibility=View.VISIBLE
            imageView.visibility=View.GONE
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }
        supportActionBar?.show()


    }


}