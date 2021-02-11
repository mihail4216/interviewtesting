package com.misendem.interviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val TAG = "MAIN_ACTIVITY"
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.d(
                TAG,
                "OnDestinationChangedListener: ${controller} ::::: ${destination} :::::: ${arguments} "
            )
        }
    }
}