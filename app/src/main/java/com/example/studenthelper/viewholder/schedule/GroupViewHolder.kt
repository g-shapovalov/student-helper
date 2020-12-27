package com.example.studenthelper.viewholder.schedule

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R

class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var groupName: TextView = view.findViewById(R.id.tvGroupName)
}