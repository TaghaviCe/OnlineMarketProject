package com.example.onlinemarketproject

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //splash screen
        supportActionBar?.hide()
        val imageView = findViewById<ImageView>(R.id.splash_screen)
        val fragment = findViewById<View>(R.id.fragmentContainerView)
        val navigationBottom=findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)

        imageView.alpha=0f
        imageView.animate().setDuration(1500).alpha(1f).withEndAction {
            fragment.visibility=View.VISIBLE
            imageView.visibility=View.GONE
            navigationBottom.visibility=View.VISIBLE
            val navController = findNavController(R.id.fragmentContainerView)
            navigationBottom.setupWithNavController(navController)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }



       // supportActionBar?.show()


    }
//    override fun onRequestPermissionsResult(requestCode: Int,
//                                            permissions: Array<String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when (requestCode) {
//            PERMISSION_REQUEST_CODE
//
//            -> {
//                // If request is cancelled, the result arrays are empty.
//                if ((grantResults.isNotEmpty() &&
//                            grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                    // Permission is granted. Continue the action or workflow
//                    // in your app.
//                } else {
//                    // Explain to the user that the feature is unavailable because
//                    // the features requires a permission that the user has denied.
//                    // At the same time, respect the user's decision. Don't link to
//                    // system settings in an effort to convince the user to change
//                    // their decision.
//                }
//                return
//            }
//
//            // Add other 'when' lines to check for other
//            // permissions this app might request.
//            else -> {
//                // Ignore all other requests.
//            }
//        }
//    }



}