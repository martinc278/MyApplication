package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BottleViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
    var nameToChange: TextView
    var priceToChange: TextView

    init {
        this.nameToChange = rootView.findViewById(R.id.r_icon_txv_nameToChange)
        this.priceToChange = rootView.findViewById(R.id.r_icon_txv_priceToChange)
    }

}