package com.example.studenthelper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R.layout.item_group
import com.example.studenthelper.`interface`.OnItemClickListener
import com.example.studenthelper.dto.GroupDto
import com.example.studenthelper.viewholder.GroupViewHolder

class GroupAdapter(
    private var groupList: List<GroupDto>
) : RecyclerView.Adapter<GroupViewHolder>() {

    private lateinit var listener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GroupViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(item_group, parent, false)
        )

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.groupName.text = groupList[position].name
    }

    override fun getItemCount(): Int = groupList.size

//    private var onItemClickListener: ((GroupDto) -> Unit)? = null
//
//    fun setOnItemClickListener(listener: (GroupDto) -> Unit) {
//        onItemClickListener = listener
//    }
}
