package com.example.studenthelper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.dto.PairsDto
import com.example.studenthelper.viewholder.PairsViewHolder

class PairsAdapter(
    private var pairsList: List<PairsDto>
) : RecyclerView.Adapter<PairsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PairsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pair, parent, false)
        )

    override fun onBindViewHolder(holder: PairsViewHolder, position: Int) {
        holder.apply {
            kind.text = pairsList[position].kind
            name.text = pairsList[position].name
            startTime.text = pairsList[position].startTime
            teacher.text = pairsList[position].teacher
            place.text = pairsList[position].place
        }
    }

    override fun getItemCount(): Int = pairsList.size

}