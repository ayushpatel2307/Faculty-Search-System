package com.example.facultysearchsystem1

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers.Main

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
//class CustomAdapter2(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter2.ViewHolder>(){
class CustomAdapter2(private val mList: List<ItemsViewModel>, private val itemClickListener: ((View) -> Unit)? = null,private val listener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO: Implement this method
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return CustomAdapter2.ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Implement this method
        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text



//        Log.d("TAG", " $value")
        var k = Main2.value
        holder.textView.setOnClickListener {
            val item = mList[position]
//            for (i in ra) {
//                if (item.text.toString() == i) {
//                    val intent = Intent(holder.itemView.context, Main2::class.java)
//                    intent.putExtra("key", item.text)
//                    holder.itemView.context.startActivity(intent)
//                    k = item.text
////                    Log.d("TAGca_first_forloop", "hello/$k")
//                }
//            }

            getFacultyList(k) { facultylist ->

                for (i in facultylist) {
                    Log.d("TAGcca", " $i hhhhhhh")
                    if (item.text.toString() == i.toString()) {
                        val intent2 = Intent(holder.itemView.context, Main3::class.java)
                        intent2.putExtra("key", item.text)
                        holder.itemView.context.startActivity(intent2)
                        Log.d("TAGget_in_ca_for2", "hello")
                    }
                }
            }

        }
//        holder.textView.setOnClickListener {
//            // Call the click listener when the item is clicked
////            onItemClickListener?.onItemClick(mList[position])
//        }
//        holder.textView.maxLines = 2
//        holder.textView.singleLine = false
//        holder.textView.maxLines = Integer.MAX_VALUE
    }

    override fun getItemCount(): Int {
        // TODO: Implement this method
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO: Implement this class
//        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}
