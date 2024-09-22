package com.example.facultysearchsystem1

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facultysearchsystem1.databinding.ActivitySearchBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import android.widget.EditText

class search : AppCompatActivity() {
    private lateinit var searchBar: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchBar = findViewById(R.id.search_bar)
        // Retrieve the search query from the intent
        val searchQuery = intent.getStringExtra("SEARCH_QUERY") ?: ""

        // Use the search query to perform the search or display results
//        performSearch(searchQuery)
        performSearch(searchQuery) { results ->
            // Handle the search results here
            val adapter = CustomAdapter2(results) { view ->
                // Handle item click if necessary
            }
            // Assuming you have a RecyclerView or similar to set the adapter
            // recyclerView.adapter = adapter
        }
    }
//    override fun onResume() {
//        super.onResume()
//        // Clear the search bar text when returning to this activity
//        searchBar.text.clear()
//    }

    private fun performSearch(query: String, callback: (List<ItemsViewModel>) -> Unit) {
        // Implement your search logic here
        val facultylist = ArrayList<ItemsViewModel>()
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)
        FirebaseApp.initializeApp(this)
        val rootRef = FirebaseDatabase.getInstance().reference
        val hotelRef = rootRef.child("facultydetails")
        val eventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                    val fname = ds.child("NAME").getValue(String::class.java)
                    val fresarea = ds.child("RESEARCH AREA").getValue(String::class.java)
                    if (fname != null && fresarea != null && (fname.contains(
                            query,
                            ignoreCase = true
                        ) )
                    ) {
                        facultylist.add(ItemsViewModel(fname, R.drawable.fa4))
                    }

                    val adapter = CustomAdapter2(facultylist) { view ->
                    }
                    recyclerview.adapter = adapter
                }
            }
                override fun onCancelled(error: DatabaseError) {
                    // Handle possible errors here
                    Log.e("Firebase", "Error getting data: ${error.message}")
                }


            }

        hotelRef.addListenerForSingleValueEvent(eventListener)
    }
}