package com.example.facultysearchsystem1
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.accessibility.AccessibilityNodeInfo
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facultysearchsystem1.CustomAdapter2
import com.example.facultysearchsystem1.ItemsViewModel2
import com.example.facultysearchsystem1.Main2.Companion.value
import com.example.facultysearchsystem1.R
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*

class Main3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val value = intent.getStringExtra("key").toString()
        val data = ArrayList<ItemsViewModel>()
        Log.d(
            "TAGvvv",
            "$value"
        )



        val rootRef = FirebaseDatabase.getInstance().reference
        val hotelRef = rootRef.child("facultydetails")
        val eventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                    val fname = ds.child("NAME").getValue(String::class.java)
                    if(fname.toString() == value) {
                        val femail = ds.child("EMAIL").getValue(String::class.java)
//                        val fname = ds.child("NAME").getValue(String::class.java)
                        val fbtech = ds.child("B TECH").getValue(String::class.java)
                        val fmtech = ds.child("M TECH").getValue(String::class.java)
                        val fresarea = ds.child("RESEARCH AREA").getValue(String::class.java)
                        val fgsid = ds.child("GS").getValue(String::class.java)
                        val fscopussid = ds.child("SCOPUS").getValue(String::class.java)
                        val forcid = ds.child("ORCID").getValue(String::class.java)
                        val fphd = ds.child("PHD").getValue(String::class.java)
                        data.add(ItemsViewModel("Name: " +fname.toString() , R.drawable.det1))
                        data.add(ItemsViewModel("Email: " +femail.toString(), R.drawable.det1))
                        data.add(ItemsViewModel("Research Area: " +fresarea.toString(), R.drawable.det1))
                        data.add(ItemsViewModel("BTech: " +fbtech.toString(), R.drawable.det1))
                        data.add(ItemsViewModel("MTech: " +fmtech.toString(), R.drawable.det1))

                        data.add(ItemsViewModel("PHD: " +fphd.toString(), R.drawable.det1))
                        data.add(ItemsViewModel("GS ID: " +fgsid.toString(), R.drawable.det1))
                        data.add(ItemsViewModel("SCOPUS ID: " +fscopussid.toString(), R.drawable.det1))
                        data.add(ItemsViewModel("ORCID ID: " +forcid.toString(), R.drawable.det1))
                        Log.d(
                            "TAG",
                            " $fname/$femail / $fbtech/$fmtech/$fresarea / $fgsid/$fscopussid/$forcid / $fphd"
                        )
                        val adapter = CustomAdapter3(data){ view ->
                        }
                        recyclerview.adapter = adapter
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Firebase", "Error getting data: ${databaseError.message}")
            }
        }
        hotelRef.addListenerForSingleValueEvent(eventListener)

    }




}
