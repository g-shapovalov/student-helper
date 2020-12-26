package com.example.studenthelper.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.R.id.rvGroups
import com.example.studenthelper.R.layout.fragment_groups
import com.example.studenthelper.adapter.GroupAdapter
import com.example.studenthelper.dto.GroupDto

class GroupsFragment : Fragment(fragment_groups) {
    private lateinit var groupAdapter: GroupAdapter
    private var groupList: List<GroupDto> = listOf(
        GroupDto("4 КБ"),
        GroupDto("5 КБ"),
        GroupDto("6 КБ"),
        GroupDto("7 КБ"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        groupAdapter = GroupAdapter(groupList)

        view.findViewById<RecyclerView>(rvGroups).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = groupAdapter
        }

        groupAdapter.setOnItemClickListener {
            findNavController().navigate(
                R.id.action_groupsFragment_to_weekdaysFragment
            )
        }
    }

}
