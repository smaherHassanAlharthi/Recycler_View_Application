package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smaher.recycler_view_application.R
import kotlinx.android.synthetic.main.item_row.view.*


class RecyclerViewAdapter(val tasks: ArrayList<String>):
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val task = tasks[position]

        holder.itemView.apply {
            tvColor.text=task
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

}