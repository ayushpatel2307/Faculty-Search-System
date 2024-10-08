package com.example.facultysearchsystem1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


private fun getFacultyList(value: String, callback: (List<String>) -> Unit) {
    val facultylist = mutableListOf<String>()

    // your existing code
    val rootRef = FirebaseDatabase.getInstance().reference
    val hotelRef = rootRef.child("facultydetails")
    val eventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            for (ds in dataSnapshot.children) {
                val fname = ds.child("NAME").getValue(String::class.java)
                val fresarea = ds.child("RESEARCH AREA").getValue(String::class.java)
                if (fname != null && fresarea != null && (fname.contains(value, ignoreCase = true) || fresarea.contains(value, ignoreCase = true))) {
                    facultylist.add(fname)
                    Log.d("TAGoutca2", " $fname//$fresarea")
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
class Main2 : AppCompatActivity() {
    companion object {
        var value = String()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()

        value = intent.getStringExtra("key").toString()

        getFacultyList(value) { facultylist ->
            for (i in facultylist) {
                data.add(ItemsViewModel(i,R.drawable.fa4))
            }
            val adapter = CustomAdapter2(data) { view ->
            }

            recyclerview.adapter = adapter
        }

    }

}

