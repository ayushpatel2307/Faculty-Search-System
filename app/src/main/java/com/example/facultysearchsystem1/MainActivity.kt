package com.example.facultysearchsystem1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()
        val ra = listOf("ra1","ra2","ra3","ra4","ra5")

        for(i in ra)
        {
            data.add(ItemsViewModel(i))
            resarea = i
        }

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
    }
}

