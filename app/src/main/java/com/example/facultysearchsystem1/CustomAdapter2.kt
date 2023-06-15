package com.example.facultysearchsystem1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter2(private val mList: List<ItemsViewModel2>) : RecyclerView.Adapter<CustomAdapter2.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO: Implement this method
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design2, parent, false)

        return CustomAdapter2.ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: Implement this method
        val ItemsViewModel = mList[position]
//        holder.imageView.setImageResource(ItemsViewModel.image)
//        holder.itemView.tag = position
//        holder.itemView.setOnClickListener(itemClickListener)
        holder.textView.text = ItemsViewModel.text
//        val arrowImageView = holder.itemView.findViewById<ImageView>(R.id.arrow)
//        arrowImageView.setOnClickListener(listener)
//        holder.textView.setOnClickListener {
//            val item = mList[position]
//            val intent = Intent(holder.itemView.context, Main2::class.java)
//            intent.putExtra("key", item.text)
//            holder.itemView.context.startActivity(intent)
//        }
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
