package com.example.studenthelper.viewholder.profile

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R

class SemestrViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView = view.findViewById(R.id.tvSemestrName)
}