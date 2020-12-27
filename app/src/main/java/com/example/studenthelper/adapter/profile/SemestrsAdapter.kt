package com.example.studenthelper.adapter.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.dto.profile.SemestrDto
import com.example.studenthelper.viewholder.profile.SemestrViewHolder

class SemestrsAdapter(
    private var semestrsList: List<SemestrDto>
) : RecyclerView.Adapter<SemestrViewHolder>() {

    private var onItemClickListener: ((SemestrDto) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SemestrViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_semestr, parent, false)
        )

    override fun onBindViewHolder(holder: SemestrViewHolder, position: Int) {
        val semestrDto = semestrsList[position]
        holder.name.text = semestrsList[position].name
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(semestrDto) }
        }
    }

    override fun getItemCount(): Int = semestrsList.size

    fun setOnItemClickListener(listener: (SemestrDto) -> Unit) {
        onItemClickListener = listener
    }
}