package com.example.facultysearchsystem1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Main2 : AppCompatActivity() {
    private var resarea: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
//        for (i in 1..20) {
//            data.add(ItemsViewModel(R.drawable.vit_logo, "Faculty " + i))
//        }
        resarea = intent.getStringExtra("name").toString()

        //val temp = resarea.toString()

//        val adata = CustomAdapter(data, View.OnClickListener { text })
//        var temppp : String = adata.researcharea
//        var temp = intent.getStringExtra("name") ?: "default value"
        val ra1 = listOf("f1.1","f1.2","f1.3","f1.4","f1.5")
        val ra2 = listOf("f2.1","f2.2","f2.3","f2.4","f2.5")
        val ra3 = listOf("f3.1","f3.2","f3.3","f3.4","f3.5")
        val ra4 = listOf("f4.1","f4.2","f4.3","f4.4","f4.5")
        val ra5 = listOf("f5.1","f5.2","f5.3","f5.4","f5.5")
        val fl = listOf("f1.1","f1.2","f1.3","f1.4","f1.5","f2.1","f2.2","f2.3","f2.4","f2.5","f3.1","f3.2","f3.3","f3.4","f3.5","f4.1","f4.2","f4.3","f4.4","f4.5","f5.1","f5.2","f5.3","f5.4","f5.5")
        val value = intent.getStringExtra("key").toString()

        if (value == "ra1")
        {
            for (i in ra1) {
                data.add(ItemsViewModel(i))
            }
        }
//        if (value == "ra2")
//        {
//            for (i in ra2) {
//                data.add(ItemsViewModel(R.drawable.vit_logo, i))
//            }
//        }
//        if (value == "ra3")
//        {
//            for (i in ra3) {
//                data.add(ItemsViewModel(R.drawable.vit_logo, i))
//            }
//        }
//        if (value == "ra4")
//        {
//            for (i in ra4) {
//                data.add(ItemsViewModel(R.drawable.vit_logo, i))
//            }
//        }
//        if (value == "ra5")
//        {
//            for (i in ra5) {
//                data.add(ItemsViewModel(R.drawable.vit_logo, i))
//            }
//        }


//        for (i in 1..20) {
//            data.add(ItemsViewModel(R.drawable.vit_logo, "hello "+ value))
//        }
        val adapter = CustomAdapter(data) { view ->
//            val position = view.tag as Int
//            val str = data[position].text
//            val iinext = Intent(this, Main3::class.java)
//            iinext.putExtra("keyy", str)
//            startActivity(iinext)
        }
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }

}