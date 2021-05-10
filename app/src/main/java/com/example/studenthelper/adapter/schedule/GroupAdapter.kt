package com.example.studenthelper.adapter.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R.layout.item_group
import com.example.studenthelper.api.schedule.models.Group
import com.example.studenthelper.dto.schedule.GroupDto
import com.example.studenthelper.viewholder.schedule.GroupViewHolder

class GroupAdapter() : RecyclerView.Adapter<GroupViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Group>() {

        override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    private var onItemClickListener: ((Group) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GroupViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(item_group, parent, false)
        )

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val group = differ.currentList[position]
        holder.groupName.text = group.name
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(group) }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun setOnItemClickListener(listener: (Group) -> Unit) {
        onItemClickListener = listener
    }
}
