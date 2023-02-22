package com.example.parcijalniispit

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class PodaciAdapter(private val items: ArrayList<fragment.Podaci>):
    RecyclerView.Adapter<PodaciAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)


        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = items[position]
        holder.podsjetnik.setText(currentItem.pdosjetnik.toString())
        holder.detalji.setText(currentItem.detalji.toString())
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val podsjetnik : TextView = itemView.findViewById(R.id.podaciPodsjetnik)
        val detalji : TextView = itemView.findViewById(R.id.podaciDetalji)
    }
}


