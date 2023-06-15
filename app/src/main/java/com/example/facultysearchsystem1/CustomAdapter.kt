package com.example.facultysearchsystem1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent
//lateinit var researcharea: String

class CustomAdapter(private val mList: List<ItemsViewModel>, private val itemClickListener: ((View) -> Unit)? = null,private val listener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    public lateinit var researcharea: String

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ra = listOf("ra1","ra2","ra3","ra4","ra5")
        val fl = listOf("f1.1","f1.2","f1.3","f1.4","f1.5","f2.1","f2.2","f2.3","f2.4","f2.5","f3.1","f3.2","f3.3","f3.4","f3.5","f4.1","f4.2","f4.3","f4.4","f4.5","f5.1","f5.2","f5.3","f5.4","f5.5")
        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)
//        holder.itemView.tag = position
//        holder.itemView.setOnClickListener(itemClickListener)
        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text
//        val arrowImageView = holder.itemView.findViewById<ImageView>(R.id.arrow)
//        arrowImageView.setOnClickListener(listener)
//        holder.itemView.setOnClickListener {
//            val clickedItem = mList[position] // Get the clicked item from the list
//            val context = holder.itemView.context // Get the context of the item view
//            researcharea = context.toString();
//
        holder.textView.setOnClickListener {
                val item = mList[position]
            for(i in ra) {
                if (item.text.toString() == i)
                {
                    val intent = Intent(holder.itemView.context, Main2::class.java)
                    intent.putExtra("key", item.text)
                    holder.itemView.context.startActivity(intent)
                }
            }
            for(i in fl) {
                if (item.text.toString() == i)
                {
                    val intent = Intent(holder.itemView.context, Main3::class.java)
                    intent.putExtra("key", item.text)
                    holder.itemView.context.startActivity(intent)
                }
            }
//                val intent = Intent(holder.itemView.context, Main3::class.java)
//                intent.putExtra("key", item.text)
//                holder.itemView.context.startActivity(intent)
            }


    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

}

/*
//class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
//
//    private val mContext: Context
//
//    init {
//        mContext = parent.context
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.card_view_design, parent, false)
//
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = mList[position]
//        holder.imageView.setImageResource(item.image)
//        holder.textView.text = item.text
//    }
//
//    override fun getItemCount(): Int {
//        return mList.size
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        val imageView: ImageView = itemView.findViewById(R.id.imageview)
//        val textView: TextView = itemView.findViewById(R.id.textView)
//
//        init {
//            itemView.setOnClickListener {
//                val item = mList[adapterPosition]
//                val intent = Intent(mContext, NextActivity::class.java)
//                intent.putExtra("variable_name", item.variable) // replace with the actual variable name
//                mContext.startActivity(intent)
//            }
//        }
//    }
//}
//*/






//
//package com.example.facultysearchsystem1
//
//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
////import com.example.facultysearchsystem1.ItemsViewModel
////import com.example.facultysearchsystem1.R
////import com.example.facultysearchsystem1.ItemsViewModel
////import com.example.facultysearchsystem1.R
//import kotlinx.coroutines.NonDisposableHandle.parent
//
//class CustomAdapter(private val mList: List<ItemsViewModel>, private val listener: View.OnClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
//    public lateinit var researcharea: String
//
//    // create new views
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        // inflates the card_view_design view
//        // that is used to hold list item
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.card_view_design, parent, false)
//
//        return ViewHolder(view)
//    }
//
//    // binds the list items to a view
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        val ItemsViewModel = mList[position]
//
//        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)
//
//        // sets the text to the textview from our itemHolder class
//        holder.textView.text = ItemsViewModel.text
//        val arrowImageView = holder.itemView.findViewById<ImageView>(R.id.arrow)
//        arrowImageView.setOnClickListener(listener)
//        holder.itemView.setOnClickListener {
//            val clickedItem = mList[position] // Get the clicked item from the list
//            val context = holder.itemView.context // Get the context of the item view
//            researcharea = context.toString();
//        }
//    }
//
//    // return the number of the items in the list
//    override fun getItemCount(): Int {
//        return mList.size
//    }
//
//    // Holds the views for adding it to image and text
//    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val imageView: ImageView = itemView.findViewById(R.id.imageview)
//        val textView: TextView = itemView.findViewById(R.id.textView)
//    }
//
//}

/*
class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val mContext: Context

    init {
        mContext = parent.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.imageView.setImageResource(item.image)
        holder.textView.text = item.text
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)

        init {
            itemView.setOnClickListener {
                val item = mList[adapterPosition]
                val intent = Intent(mContext, NextActivity::class.java)
                intent.putExtra("variable_name", item.variable) // replace with the actual variable name
                mContext.startActivity(intent)
            }
        }
    }
}
*/