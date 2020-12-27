package com.example.studenthelper.viewholder.schedule

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R

class SubjectViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView = view.findViewById(R.id.tvSubjectName)
    var credit: TextView = view.findViewById(R.id.tvSubjectCredit)
    var exam: TextView = view.findViewById(R.id.tvSubjectExam)
}