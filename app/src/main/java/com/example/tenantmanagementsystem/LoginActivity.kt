
package com.example.tenantmanagementsystem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val TAG = "ActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d(TAG, "onCreate called")

        val usernameEditText =
            findViewById<EditText>(R.id.usernameEditText)

        val loginButton =
            findViewById<Button>(R.id.loginButton)

        val registerButton =
            findViewById<Button>(R.id.registerButton)

        val websiteButton =
            findViewById<Button>(R.id.websiteButton)

        val dialerButton =
            findViewById<Button>(R.id.dialerButton)


        val fragmentsButton =
            findViewById<Button>(R.id.fragmentsButton)


        fragmentsButton.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }



        // Restore username after screen rotation
        if (savedInstanceState != null) {
            val savedUsername =
                savedInstanceState.getString("USERNAME", "")

            usernameEditText.setText(savedUsername)
        }

        // Explicit Intent: MainActivity
        loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Explicit Intent: RegisterActivity
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Implicit Intent: Website
        websiteButton.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.strathmore.edu")
            )
            startActivity(intent)
        }

        // Implicit Intent: Dialer
        dialerButton.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:0712345678")
            )
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val usernameEditText =
            findViewById<EditText>(R.id.usernameEditText)

        outState.putString(
            "USERNAME",
            usernameEditText.text.toString()
        )

        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}
