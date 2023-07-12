package com.example.facultysearchsystem1

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facultysearchsystem1.Main2.Companion.value
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.NonDisposableHandle.parent
//lateinit var researcharea: String
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
                if (value.toString() == fresarea.toString()) {
                    facultylist.add(fname!!)
//                    Log.d("TAGoutca2", " $fname//$fresarea")
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
class CustomAdapter(private val mList: List<ItemsViewModel>, private val itemClickListener: ((View) -> Unit)? = null,private val listener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{
    public lateinit var researcharea: String
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ra = listOf("Artificial Intelligence", "Network and Security", "Imaging and Computer Vision", "Cyber Physical Systems", "Data Analytics")
        val ItemsViewModel = mList[position]
        holder.textView.text = ItemsViewModel.text
        holder.imageView.setImageResource(ItemsViewModel.imageView)
        var k = String()
        holder.textView.setOnClickListener {
            val item = mList[position]
            for (i in ra) {
                if (item.text.toString() == i) {
                    val intent = Intent(holder.itemView.context, Main2::class.java)
                    intent.putExtra("key", item.text)
                    holder.itemView.context.startActivity(intent)
                    k = item.text
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)
    }

}
