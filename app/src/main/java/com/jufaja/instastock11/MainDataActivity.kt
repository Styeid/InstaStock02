package com.jufaja.instastock11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.jufaja.instastock11.models.DataPost

private const val TAG = "MainDataActivity"
class MainDataActivity : AppCompatActivity() {

    private lateinit var firebaseDb: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_data)

        // query to Firestore to retrieve data
        firebaseDb = FirebaseFirestore.getInstance()
        val datapostReference = firebaseDb
            .collection("datapost")
            .limit(20)
            .orderBy("fund", Query.Direction.ASCENDING)
        datapostReference.addSnapshotListener { snapshot, exeption ->
            if (exeption != null || snapshot == null) {
                Log.e(TAG, "Exeption when querying dataposts", exeption)
                return@addSnapshotListener
            }
            val dataPostList = snapshot.toObjects(DataPost::class.java)
            for (dataPost in dataPostList) {
                Log.i(TAG, "DataPosts $dataPost")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_data_hist, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.icdtahistory) {
            val intent = Intent(this, DataHistoryActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}