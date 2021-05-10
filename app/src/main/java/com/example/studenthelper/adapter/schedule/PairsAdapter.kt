package com.example.studenthelper.adapter.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.viewholder.schedule.PairsViewHolder
import com.example.studenthelper.api.schedule.models.Pair as StudentPair

class PairsAdapter() : RecyclerView.Adapter<PairsViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<StudentPair>() {

        override fun areItemsTheSame(oldItem: StudentPair, newItem: StudentPair): Boolean {
            return oldItem.name + oldItem.kind == newItem.name + oldItem.kind
        }

        override fun areContentsTheSame(oldItem: StudentPair, newItem: StudentPair): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PairsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pair, parent, false)
        )

    override fun onBindViewHolder(holder: PairsViewHolder, position: Int) {
        val pair = differ.currentList[position]
        holder.apply {
            kind.text = pair.kind
            name.text = pair.name
            startTime.text = pair.start_time
            teacher.text = pair.teacher
            place.text = pair.place
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

}