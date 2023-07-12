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
import java.security.Security

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()

        val ra = listOf("Artificial Intelligence", "Network and Security", "Imaging and Computer Vision", "Cyber Physical Systems", "Data Analytics")
        for (i in ra) {
            data.add(ItemsViewModel(i , R.drawable.ra4))
        }
        val adapter = CustomAdapter(data) {
        }
        recyclerview.adapter = adapter
    }
}

