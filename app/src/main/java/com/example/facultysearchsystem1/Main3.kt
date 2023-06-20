package com.example.facultysearchsystem1
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facultysearchsystem1.CustomAdapter2
import com.example.facultysearchsystem1.ItemsViewModel2
import com.example.facultysearchsystem1.Main2.Companion.value
import com.example.facultysearchsystem1.R
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*

//package com.example.facultysearchsystem1
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.TextView
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class Main3 : AppCompatActivity() {
//    private var resarea: String = ""
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main3)
//
//           val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)
////
////            // this creates a vertical layout Manager
//           recyclerview.layoutManager = LinearLayoutManager(this)
////            val fname = findViewById<TextView>(R.id.textViewname)
////            val fempid = findViewById<TextView>(R.id.textViewempid)
////            val femail = findViewById<TextView>(R.id.textViewemail)
////            val fbtech = findViewById<TextView>(R.id.textViewbtech)
////            val fmtech = findViewById<TextView>(R.id.textViewmtech)
////            val fphd = findViewById<TextView>(R.id.textViewphd)
////            val forcid = findViewById<TextView>(R.id.textVieworcid)
////            val fscoupsid = findViewById<TextView>(R.id.textViewscopusid)
////            val fgsid = findViewById<TextView>(R.id.textViewgsid)
//            // ArrayList of class ItemsViewModel
//            val data = ArrayList<ItemsViewModel2>()
//
//            // This loop will create 20 Views containing
//            // the image with the count of view
////        for (i in 1..20) {
////            data.add(ItemsViewModel(R.drawable.vit_logo, "Faculty " + i))
////        }
////            resarea = intent.getStringExtra("name").toString()
//
//            //val temp = resarea.toString()
//
////        val adata = CustomAdapter(data, View.OnClickListener { text })
////        var temppp : String = adata.researcharea
////        var temp = intent.getStringExtra("name") ?: "default value"
//            val ra1 = listOf("f1.1","f1.2","f1.3","f1.4","f1.5")
//            val ra2 = listOf("f2.1","f2.2","f2.3","f2.4","f2.5")
//            val ra3 = listOf("f3.1","f3.2","f3.3","f3.4","f3.5")
//            val ra4 = listOf("f4.1","f4.2","f4.3","f4.4","f4.5")
//            val ra5 = listOf("f5.1","f5.2","f5.3","f5.4","f5.5")
//            val f1 = listOf("Praveen Joe I R", "5396","praveen.joe@vit.ac.in","vit","vit","vit","orid","scid","gogsid")
//            val fl = listOf("f1.1","f1.2","f1.3","f1.4","f1.5","f2.1","f2.2","f2.3","f2.4","f2.5","f3.1","f3.2","f3.3","f3.4","f3.5","f4.1","f4.2","f4.3","f4.4","f4.5","f5.1","f5.2","f5.3","f5.4","f5.5")
//            val value = intent.getStringExtra("key").toString()
//
//            if (value == "f1.1") {
////                fname.setText(f1[0])
////                fempid.setText(f1[1])
////                femail.setText(f1[2])
////                fbtech.setText(f1[3])
////                fmtech.setText(f1[4])
////                fphd.setText(f1[5])
////                forcid.setText(f1[6])
////                fscoupsid.setText(f1[7])
////                fgsid.setText(f1[8])
//            }
//            if (value == "f1.1")
//            {
//                for (i in f1) {
//                    data.add(ItemsViewModel2(R.drawable.vitl, i))
//                }
//            }
////            if (value == "ra3")
////            {
////                for (i in ra3) {
////                    data.add(ItemsViewModel(R.drawable.vit_logo, i))
////                }
////            }
////            if (value == "ra4")
////            {
////                for (i in ra4) {
////                    data.add(ItemsViewModel(R.drawable.vit_logo, i))
////                }
////            }
////            if (value == "ra5")
////            {
////                for (i in ra5) {
////                    data.add(ItemsViewModel(R.drawable.vit_logo, i))
////                }
////            }
//
////        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
////        val adapter = CustomAdapter2(data { view ->
////
////        })
//        val adapter = CustomAdapter2(data){ view ->
//            //val iNext = Intent(this, Activity4::class.java);
//            //startActivity(iNext);
//        }
//        recyclerview.adapter = adapter
//        // Use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
////        recyclerView.setHasFixedSize(true)
//
////        for (i in 1..20) {
////            data.add(ItemsViewModel(R.drawable.vit_logo, "hello "+ value))
////        }
////            val adapter = CustomAdapter(data) { view ->
//////            val position = view.tag as Int
//////            val str = data[position].text
//////            val iinext = Intent(this, Main3::class.java)
//////            iinext.putExtra("keyy", str)
//////            startActivity(iinext)
////            }
////            // Setting the Adapter with the recyclerview
////            recyclerview.adapter = adapter
//
//        }
//
//    }
//
class Main3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)
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
                        data.add(ItemsViewModel("Name: " +fname.toString()))
                        data.add(ItemsViewModel("Email: " +femail.toString()))
                        data.add(ItemsViewModel("Research Area: " +fresarea.toString()))
                        data.add(ItemsViewModel("BTech: " +fbtech.toString()))
                        data.add(ItemsViewModel("MTech: " +fmtech.toString()))

                        data.add(ItemsViewModel("PHD: " +fphd.toString()))
                        data.add(ItemsViewModel("GS ID: " +fgsid.toString()))
                        data.add(ItemsViewModel("SCOPUS ID: " +fscopussid.toString()))
                        data.add(ItemsViewModel("ORCID ID: " +forcid.toString()))
                        Log.d(
                            "TAG",
                            " $fname/$femail / $fbtech/$fmtech/$fresarea / $fgsid/$fscopussid/$forcid / $fphd"
                        )
                        val adapter = CustomAdapter2(data){ view ->
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




//    )
    }
}
