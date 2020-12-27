package com.example.studenthelper.viewholder.schedule

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R

class PairsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView = view.findViewById(R.id.tvPairName)
    var kind: TextView = view.findViewById(R.id.tvPairKind)
    var teacher: TextView = view.findViewById(R.id.tvPairTeacher)
    var startTime: TextView = view.findViewById(R.id.tvPairStartTime)
    var place: TextView = view.findViewById(R.id.tvPairPlace)
}