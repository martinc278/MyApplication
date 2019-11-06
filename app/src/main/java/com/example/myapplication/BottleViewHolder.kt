package com.example.myapplication

import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BottleViewHolder(rootView: View, onItemClickListener: AdapterView.OnItemClickListener) : RecyclerView.ViewHolder(rootView) {
    var nameToChange: TextView
    var priceToChange: TextView
    var delete: Button

    init {
        this.nameToChange = rootView.findViewById(R.id.r_icon_txv_nameToChange)
        this.priceToChange = rootView.findViewById(R.id.r_icon_txv_priceToChange)
        this.delete = rootView.findViewById(R.id.r_icon_delete)
        this.delete.setOnClickListener {
            onItemClickListener.onItemClick(null, it, adapterPosition, 0L)
        }
    }
}