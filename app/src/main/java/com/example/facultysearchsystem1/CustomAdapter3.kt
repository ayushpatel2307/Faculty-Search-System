package com.example.facultysearchsystem1


import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import android.content.ClipboardManager
import android.content.ClipData
import androidx.core.content.ContextCompat.getSystemService

private fun getFacultyList(value: String, callback: (List<String>) -> Unit) {
    val facultylist = mutableListOf<String>()

    val rootRef = FirebaseDatabase.getInstance().reference
    val hotelRef = rootRef.child("facultydetails")
    val eventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            for (ds in dataSnapshot.children) {
                val fname = ds.child("NAME").getValue(String::class.java)
                val fresarea = ds.child("RESEARCH AREA").getValue(String::class.java)
                if (value.toString() == fresarea.toString()) {
                    facultylist.add(fname!!)
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
//class CustomAdapter3(
//    private val context: Context,
//    private val mList: List<ItemsViewModel>,
//    private val itemClickListener: ((View) -> Unit)? = null,
//    private val listener: View.OnClickListener
//) : RecyclerView.Adapter<CustomAdapter3.ViewHolder>() {
class CustomAdapter3(private val mList: List<ItemsViewModel>, private val itemClickListener: ((View) -> Unit)? = null,private val listener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter3.ViewHolder>() {
//class CustomAdapter3(private val mList: List<ItemsViewModel>, private val context: ValueEventListener, private val itemClickListener: ((View) -> Unit)? = null, private val listener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter3.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO: Implement this method
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design2, parent, false)

        return CustomAdapter3.ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Implement this method
        val ItemsViewModel = mList[position]

        holder.textView.text = ItemsViewModel.text
        holder.imageView.setImageResource(ItemsViewModel.imageView)
        var k = Main2.value
        holder.textView.setOnClickListener {
            val item = mList[position]
            val searchText: String = item.text
            val part = searchText.substringAfter(": ")
            val phone = searchText.substring(0, 5)
            Log.e("aaaaaaaaaaa", "asdf"+"$phone"+"asdf"+"$part"+"asas")
            if(phone=="PHONE"){

                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$part")
                }
                holder.itemView.context.startActivity(intent)
            }

            else if(part == "null"||phone == "Cabin"||phone == "Desig"||phone == "Other")
            {

            }else if(phone == "Email"){
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$part")
                }
                holder.itemView.context.startActivity(intent)
//                if (intent.resolveActivity(holder.itemView.context.packageManager) != null) {
//                    holder.itemView.context.startActivity(intent)
//                } else {
//                    Toast.makeText(holder.itemView.context, "No email client found", Toast.LENGTH_SHORT).show()
//                }
            }
            else if (part.startsWith("http://") || part.startsWith("https://")|| part.startsWith("https:..")) {
                var temp = part.substringAfter(".")
                var temp2 = "https://"
                temp =  temp2+temp
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(part))
                holder.itemView.context.startActivity(intent)
            } else {
                try {
                    // Encode the search text to be used in the URL
                    val encodedSearchText = URLEncoder.encode(part, "UTF-8")

                    // Create the Google search URL
                    val googleSearchUrl = "https://www.google.com/search?q=$encodedSearchText"

                    // Open the web browser with the Google search URL
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleSearchUrl))
                    holder.itemView.context.startActivity(intent)
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        // TODO: Implement this method
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }


//    private fun performGoogleSearch(searchText: String) {
//        try {
//            // Encode the search text to be used in the URL
//            val encodedSearchText = URLEncoder.encode(searchText, "UTF-8")
//
//            // Create the Google search URL
//            val googleSearchUrl = "https://www.google.com/search?q=$encodedSearchText"
//
//            // Open the web browser with the Google search URL
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleSearchUrl))
//            context.startActivity(intent)
//        } catch (e: UnsupportedEncodingException) {
//            e.printStackTrace()
//        }
//    }
}
