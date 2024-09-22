package com.example.facultysearchsystem1

import android.content.Intent
import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facultysearchsystem1.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
private fun getFacultyList(value: String, callback: (List<String>) -> Unit) {
    val facultylist = mutableListOf<String>()

    val rootRef = FirebaseDatabase.getInstance().reference
    val hotelRef = rootRef.child("facultydetails")
    val eventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            for (ds in dataSnapshot.children) {
                val fname = ds.child("NAME").getValue(String::class.java)
                val fresarea = ds.child("RESEARCH AREA").getValue(String::class.java)
                if (value.toString() == fresarea.toString()) {
                    facultylist.add(fname!!)
                }
            }
            callback(facultylist)
        }

        override fun onCancelled(databaseError: DatabaseError) {
            Log.e("Firebase", "Error getting data: ${databaseError.message}")
            callback(emptyList()) // return an empty list if there's an error
        }
    }
    hotelRef.addListenerForSingleValueEvent(eventListener)
}
class MainActivity : AppCompatActivity() {
    private lateinit var searchBar: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchBar = findViewById(R.id.search_bar)

//        searchBar.setOnClickListener {
//            // Handle search action here
//            performSearch(searchBar.text.toString())
//        }
//        searchBar.setOnClickListener {
//            val searchText = searchBar.text.toString()
//            val intent = Intent(this, search::class.java).apply {
//                putExtra("SEARCH_QUERY", searchText)
//            }
//            startActivity(intent)
//            searchBar.text.clear()
//        }

        searchBar.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                val searchText = searchBar.text.toString()
                val intent = Intent(this, search::class.java).apply {
                    putExtra("SEARCH_QUERY", searchText)
                }
                startActivity(intent)
                searchBar.text.clear() // Clear the text after starting the activity
                true
            } else {
                false
            }
        }
        FirebaseApp.initializeApp(this)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()

        val ra = listOf("Artificial Intelligence", "Network and Security", "Imaging and Computer Vision", "Cyber Physical Systems", "Data Analytics", "Machine Learning","Deep Learning","Internet Of Things", "Cloud Computing")
        for (i in ra) {
            data.add(ItemsViewModel(i , R.drawable.ra4))
        }
        val adapter = CustomAdapter(data) {
        }
        recyclerview.adapter = adapter
    }
}

