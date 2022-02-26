package com.jufaja.instastock11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class DataHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_history)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.iclogout) {
            Toast.makeText(this,"User is logged OUT!", Toast.LENGTH_LONG).show()
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoggiActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}