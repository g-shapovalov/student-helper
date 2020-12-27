package com.example.studenthelper.adapter.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.dto.profile.SubjectDto
import com.example.studenthelper.viewholder.schedule.SubjectViewHolder

class SubjectsAdapter(
    private var subjectsList: List<SubjectDto>
) : RecyclerView.Adapter<SubjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SubjectViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_subject, parent, false)
        )

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.apply {
            name.text = subjectsList[position].name

            val creditValue  = subjectsList[position].credit
            val examValue = subjectsList[position].exam
            if (creditValue.isEmpty() && examValue.isNotEmpty()) {
                credit.text = "+"
            } else {
                credit.text = creditValue
            }
            exam.text = examValue
        }
    }

    override fun getItemCount(): Int = subjectsList.size

}