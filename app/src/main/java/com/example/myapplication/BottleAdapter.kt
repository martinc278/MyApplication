package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BottleAdapter (private val bottles: ArrayList<Bottle>) : RecyclerView.Adapter<BottleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottleViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_bottle, parent,
            false)

        return BottleViewHolder(row)
    }

    override fun onBindViewHolder(viewholder: BottleViewHolder, position: Int) {
        val (name, prix) = this.bottles[position]

        viewholder.nameToChange.text = name
        viewholder.priceToChange.text = prix.toString()
    }

    override fun getItemCount(): Int {
        return this.bottles.size
    }

}