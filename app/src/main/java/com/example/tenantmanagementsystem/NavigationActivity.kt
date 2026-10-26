package com.example.tenantmanagementsystem

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class NavigationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_navigation)

        val toolbar = findViewById<Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        val drawerLayout =
            findViewById<DrawerLayout>(R.id.drawerLayout)

        val navigationView =
            findViewById<NavigationView>(R.id.navigationView)

        navHostFragment =
            supportFragmentManager.findFragmentById(
                R.id.nav_host_fragment
            ) as NavHostFragment

        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.dashboardFragment),
            drawerLayout
        )

        NavigationUI.setupActionBarWithNavController(
            this,
            navController,
            appBarConfiguration
        )

        NavigationUI.setupWithNavController(
            navigationView,
            navController
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menuViewTenants -> {
                navHostFragment.navController.navigate(
                    R.id.viewTenantsFragment
                )
                true
            }

            R.id.menuLogout -> {
                val intent = Intent(
                    this,
                    LoginActivity::class.java
                )

                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                            Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navHostFragment.navController,
            appBarConfiguration
        ) || super.onSupportNavigateUp()
    }
}
