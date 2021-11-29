package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*   // To be able to use the "recycler_row.xml" content

class RecyclerViewAdapter(private val userInput: List<String>): RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder>() {
    class RecycleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_row, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val rowContent = userInput[position]
        holder.itemView.apply {
            rowText.text = rowContent
        }
    }

    override fun getItemCount() = userInput.size
}