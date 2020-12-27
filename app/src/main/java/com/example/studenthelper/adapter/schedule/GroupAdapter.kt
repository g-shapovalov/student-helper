package com.example.studenthelper.adapter.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R.layout.item_group
import com.example.studenthelper.dto.schedule.GroupDto
import com.example.studenthelper.viewholder.schedule.GroupViewHolder

class GroupAdapter(
    private var groupList: List<GroupDto>
) : RecyclerView.Adapter<GroupViewHolder>() {

    private var onItemClickListener: ((GroupDto) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GroupViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(item_group, parent, false)
        )

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val groupDto = groupList[position]
        holder.groupName.text = groupList[position].name
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(groupDto) }
        }
    }

    override fun getItemCount(): Int = groupList.size

    fun setOnItemClickListener(listener: (GroupDto) -> Unit) {
        onItemClickListener = listener
    }
}
