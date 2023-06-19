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

//
//class MainActivity : AppCompatActivity() {
//
//    private var resarea: String = ""
//
//    override fun onCreate(savedInstanceState: Bundle?)
//    {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // getting the recyclerview by its id
//        //setContentView(R.layout.activity_main)
//        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
//
//        // this creates a vertical layout Manager
//        recyclerview.layoutManager = LinearLayoutManager(this)
//
//        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsViewModel>()
//        val ra = listOf("ra1","ra2","ra3","ra4","ra5")
//
//        for(i in ra)
//        {
//            data.add(ItemsViewModel(R.drawable.vit_logo, i))
//            resarea = i
//        }
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(data) { position ->
//            val str = data[position].text
//            val inext = Intent(this, Main2::class.java)
//            inext.putExtra("name", str)
//            startActivity(inext)
//        }
//
//        // Setting the Adapter with the recyclerview
//        recyclerview.adapter = adapter
//        }
//
////        // Setting the Adapter with the recyclerview
////        recyclerview.adapter = adapter
//
////        val adapter = CustomAdapter(data, View.OnClickListener {
////            var reser: String = recyclerview.getAdapter().getItemId(position).toString()
////            val iNext = Intent(this, Main2::class.java);
////            startActivity(iNext);
//
//
//
//
//}
class MainActivity : AppCompatActivity() {

    private var resarea: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()
        val ra = listOf("Artificial Intelligence", "Network and Security", "Imaging and Computer Vision", "Cyber Physical Systems", "Data Analytics")


        for (i in ra) {
            data.add(ItemsViewModel(i))
            resarea = i
        }
//        val rootRef = FirebaseDatabase.getInstance().reference
//        val hotelRef = rootRef.child("facultydetails")
//        val eventListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                for (ds in dataSnapshot.children) {
////                    val femail = ds.child("EMAIL").getValue(String::class.java)
////                    val fname = ds.child("NAME").getValue(String::class.java)
////                    val fbtech = ds.child("B TECH").getValue(String::class.java)
////                    val fmtech = ds.child("M TECH").getValue(String::class.java)
//                    val fresarea = ds.child("RESEARCH AREA").getValue(String::class.java)
////                    val fgsid = ds.child("GS").getValue(String::class.java)
////                    val fscopussid = ds.child("SCOPUS").getValue(String::class.java)
////                    val forcid = ds.child("ORCID").getValue(String::class.java)
////                    val fphd = ds.child("PHD").getValue(String::class.java)
//                    data.add(ItemsViewModel(fresarea.toString()+" hello"))
//                    Log.d("TAG", " $fresarea")
//                }
//            }
//            override fun onCancelled(databaseError: DatabaseError) {
//                Log.e("Firebase", "Error getting data: ${databaseError.message}")
//            }
//        }
//        hotelRef.addListenerForSingleValueEvent(eventListener)
        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data) {
//            val position = view.tag as Int
//            val str = data[position].text
//            val inext = Intent(this, Main3::class.java)
//            inext.putExtra("name", str)
//            startActivity(inext)
        }

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter


//class MainActivity : AppCompatActivity() {
//
////
//class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding
//    private lateinit var database: DatabaseReference
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        database = FirebaseDatabase.getInstance().getReference("Research")
//
//        val r1 = listOf(
//            "Artificial Intelligence",
//            "Dr. Nayeemulla Khan",
//            "50161",
//            "nayeemulla.khan@vit.ac.in",
//            "Madurai Kamaraj University",
//            "NULL",
//            "IIT Madras",
//            "0000-0001-7625-382X",
//            "56330471300",
//            "RKGgXgAAAAJ"
//        )
//        val r2 = listOf(
//            "Artificial Intelligence",
//            "Dr. Nayeemulla Khan",
//            "50161",
//            "nayeemulla.khan@vit.ac.in",
//            "Madurai Kamaraj University",
//            "NULL",
//            "IIT Madras",
//            "0000-0001-7625-382X",
//            "56330471300",
//            "RKGgXgAAAAJ"
//        )
//
//        for (i in listOf(r1, r2)) {
//            val researcharea = i[0].toString()
//            val facultyname = i[1].toString()
//            val facultyempid = i[2].toString()
//            val facultyemail = i[3].toString()
//            val facultybtech = i[4].toString()
//            val facultymtech = i[5].toString()
//            val facultyphd = i[6].toString()
//            val facultyorcid = i[7].toString()
//            val facultyscopusid = i[8].toString()
//            val facultygsid = i[9].toString()
//
//            val research = Research(
//                researcharea,
//                facultyname,
//                facultyempid,
//                facultyemail,
//                facultybtech,
//                facultymtech,
//                facultyphd,
//                facultyorcid,
//                facultyscopusid,
//                facultygsid
//            )
//
//            database.child(facultyempid).setValue(research)
//        }
//    }
//}
//
//    data class Research(
//        val researcharea: String,
//        val facultyname: String,
//        val facultyempid: String,
//        val facultyemail: String,
//        val facultybtech: String,
//        val facultymtech: String,
//        val facultyphd: String,
//        val facultyorcid: String,
//        val facultyscopusid: String,
//        val facultygsid: String
//    )
    }
}

