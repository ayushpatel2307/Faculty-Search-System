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
class CustomAdapter(private val mList: List<ItemsViewModel>, private val itemClickListener: ((View) -> Unit)? = null,private val listener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    public lateinit var researcharea: String
    interface OnItemClickListener {
        fun onItemClick(item: ItemsViewModel)
    }
//class CustomAdapter(private val mList: List<ItemsViewModel>, private val listener: View.OnClickListener, private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
//
//    public lateinit var researcharea: String
//
//    interface OnItemClickListener {
//        fun onItemClick(item: ItemsViewModel)
//    }
//     create new views

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ra = listOf("Artificial Intelligence", "Network and Security", "Imaging and Computer Vision", "Cyber Physical Systems", "Data Analytics")

        val fl = listOf("f1.1","f1.2","f1.3","f1.4","f1.5","f2.1","f2.2","f2.3","f2.4","f2.5","f3.1","f3.2","f3.3","f3.4","f3.5","f4.1","f4.2","f4.3","f4.4","f4.5","f5.1","f5.2","f5.3","f5.4","f5.5")
        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text



//        Log.d("TAG", " $value")
        var k = String()
        holder.textView.setOnClickListener {
            val item = mList[position]
            for (i in ra) {
                if (item.text.toString() == i) {
                    val intent = Intent(holder.itemView.context, Main2::class.java)
                    intent.putExtra("key", item.text)
                    holder.itemView.context.startActivity(intent)
                    k = item.text
//                    Log.d("TAGca_first_forloop", "hello/$k")
                }
            }

//            getFacultyList(k) { facultylist ->
//
//                for (i in facultylist) {
//                    Log.d("TAGcca", " $i hhhhhhh")
//                    if (item.text.toString() == i.toString()) {
//                        val intent2 = Intent(holder.itemView.context, Main3::class.java)
//                        intent2.putExtra("key", item.text)
//                        holder.itemView.context.startActivity(intent2)
//                        Log.d("TAGget_in_ca_for2", "hello")
//                    }
//                }
//            }

        }
        holder.textView.setOnClickListener {
            // Call the click listener when the item is clicked
//            onItemClickListener?.onItemClick(mList[position])
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

}
