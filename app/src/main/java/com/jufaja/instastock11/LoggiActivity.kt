package com.jufaja.instastock11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_loggi.*

private const val TAG = "LoggiActivity"
class LoggiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loggi)
        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            goMainDataActivity()
        }

        btnlogin.setOnClickListener {
            btnlogin.isEnabled = false
            val email = etemail.text.toString()
            val password = etpassword.text.toString()
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Email/Password cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Firebase Authentication check

            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                btnlogin.isEnabled = true
                if (task.isSuccessful) {
                    Toast.makeText(this, "Succes!", Toast.LENGTH_SHORT).show()
                    goMainDataActivity()
                } else {
                    Log.i(TAG, "signInWithEmail Failed", task.exception)
                    Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun goMainDataActivity() {
        Log.i(TAG,"goMainDataActivity")
        val intent = Intent(this, MainDataActivity::class.java)
        startActivity(intent)
        finish()
    }
}