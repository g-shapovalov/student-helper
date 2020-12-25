package com.example.studenthelper.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R.id.rvGroups
import com.example.studenthelper.R.layout.fragment_groups
import com.example.studenthelper.`interface`.OnItemClickListener
import com.example.studenthelper.adapter.GroupAdapter
import com.example.studenthelper.dto.GroupDto

class GroupsFragment : Fragment(fragment_groups) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var groupAdapter: GroupAdapter
    private var groupList: List<GroupDto> = listOf(
        GroupDto("4 КБ"),
        GroupDto("5 КБ"),
        GroupDto("6 КБ"),
        GroupDto("7 КБ"),
    )

    private fun ViewGroup?.inflate(layoutRes: Int, attachToRoot: Boolean = false) =
        LayoutInflater.from(
            context
        ).inflate(layoutRes, this, attachToRoot)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = container.inflate(fragment_groups, false)
        groupAdapter = GroupAdapter(groupList)

//        groupAdapter.setOnItemClickListener {
//            findNavController().navigate(
//                R.id.action_groupsFragment_to_weekdaysFragment
//            )
//        }

        recyclerView = view.findViewById<RecyclerView>(rvGroups).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = groupAdapter
        }



        groupAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(groupDto: GroupDto) {
                val intent = Intent(activity?.applicationContext, WeekdaysFragment::class.java)
                startActivityForResult(intent, 2)
            }
        })

        return view
    }

}
