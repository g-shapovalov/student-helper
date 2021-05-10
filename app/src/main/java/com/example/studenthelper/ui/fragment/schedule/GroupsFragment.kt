package com.example.studenthelper.ui.fragment.schedule

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.R.id.rvGroups
import com.example.studenthelper.R.layout.fragment_groups
import com.example.studenthelper.adapter.schedule.GroupAdapter
import com.example.studenthelper.ui.MainActivity
import com.example.studenthelper.ui.viewmodel.schedule.ScheduleViewModel
import com.example.studenthelper.util.Resource
import kotlinx.android.synthetic.main.fragment_groups.paginationProgressBar

class GroupsFragment : Fragment(fragment_groups) {

    lateinit var scheduleViewModel: ScheduleViewModel
    private lateinit var groupAdapter: GroupAdapter

    val TAG = "GroupFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scheduleViewModel = (activity as MainActivity).scheduleViewModel

        groupAdapter = GroupAdapter()
        view.findViewById<RecyclerView>(rvGroups).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = groupAdapter
        }
        groupAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("group", it)
            }
            findNavController().navigate(
                R.id.action_groupsFragment_to_weekdaysFragment,
                bundle
            )
        }

        scheduleViewModel.groups.observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { groupsResponse ->
                        groupAdapter.differ.submitList(groupsResponse.groups)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occurred: $message")
                        Toast.makeText(activity, "An error occurred: $message", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

}
