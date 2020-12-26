package com.example.studenthelper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.dto.GroupDto
import com.example.studenthelper.dto.WeekDaysDto
import com.example.studenthelper.viewholder.WeekdaysViewHolder

class WeekdaysAdapter(
    private var weekdaysList: List<WeekDaysDto>
) : RecyclerView.Adapter<WeekdaysViewHolder>() {

    private var onItemClickListener: ((WeekDaysDto) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WeekdaysViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weekday, parent, false)
    )

    override fun onBindViewHolder(holder: WeekdaysViewHolder, position: Int) {
        val weekdaysDto = weekdaysList[position]
        holder.name.text = weekdaysList[position].name
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(weekdaysDto) }
        }
    }

    override fun getItemCount(): Int = weekdaysList.size

    fun setOnItemClickListener(listener: (WeekDaysDto) -> Unit) {
        onItemClickListener = listener
    }
}