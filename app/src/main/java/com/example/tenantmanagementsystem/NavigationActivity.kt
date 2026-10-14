
package com.example.tenantmanagementsystem

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val navHostFragment =
            supportFragmentManager.findFragmentById(
                R.id.nav_host_fragment
            ) as NavHostFragment

        val navController = navHostFragment.navController

        findViewById<Button>(R.id.homeNavButton).setOnClickListener {
            navController.navigate(R.id.homeFragment)
        }

        findViewById<Button>(R.id.detailsNavButton).setOnClickListener {
            navController.navigate(R.id.detailsFragment)
        }

        findViewById<Button>(R.id.settingsNavButton).setOnClickListener {
            navController.navigate(R.id.settingsFragment)
        }
    }
}
