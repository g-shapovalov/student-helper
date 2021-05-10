package com.example.studenthelper.adapter.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.api.schedule.models.Group
import com.example.studenthelper.api.schedule.models.Weekday
import com.example.studenthelper.dto.schedule.WeekDaysDto
import com.example.studenthelper.util.Weekdays
import com.example.studenthelper.viewholder.schedule.WeekdaysViewHolder

class WeekdaysAdapter() : RecyclerView.Adapter<WeekdaysViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Weekday>() {

        override fun areItemsTheSame(oldItem: Weekday, newItem: Weekday): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: Weekday, newItem: Weekday): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    private var onItemClickListener: ((Weekday) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WeekdaysViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weekday, parent, false)
    )

    override fun onBindViewHolder(holder: WeekdaysViewHolder, position: Int) {
        val weekday = differ.currentList[position]
        holder.name.text = Weekdays.getByCode(weekday.number).rus
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(weekday) }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun setOnItemClickListener(listener: (Weekday) -> Unit) {
        onItemClickListener = listener
    }
}