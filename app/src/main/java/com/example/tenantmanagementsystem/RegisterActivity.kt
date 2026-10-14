
package com.example.tenantmanagementsystem

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val username = findViewById<EditText>(R.id.registerUsername)
        val email = findViewById<EditText>(R.id.registerEmail)
        val password = findViewById<EditText>(R.id.registerPassword)
        val confirmPassword = findViewById<EditText>(R.id.confirmPassword)
        val registerButton = findViewById<Button>(R.id.submitRegisterButton)

        registerButton.setOnClickListener {

            val name = username.text.toString()
            val emailAddress = email.text.toString()
            val pass = password.text.toString()
            val confirmPass = confirmPassword.text.toString()

            if (name.isBlank() || emailAddress.isBlank() ||
                pass.isBlank() || confirmPass.isBlank()) {

                Toast.makeText(
                    this,
                    "Please fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (pass != confirmPass) {

                Toast.makeText(
                    this,
                    "Passwords do not match",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Registration Successful!",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}
