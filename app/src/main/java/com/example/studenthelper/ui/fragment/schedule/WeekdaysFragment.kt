package com.example.studenthelper.ui.fragment.schedule

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.adapter.schedule.WeekdaysAdapter
import com.example.studenthelper.dto.schedule.WeekDaysDto
import com.example.studenthelper.ui.MainActivity
import com.example.studenthelper.ui.viewmodel.schedule.ScheduleViewModel
import com.example.studenthelper.util.Resource
import kotlinx.android.synthetic.main.fragment_weekdays.paginationProgressBar

class WeekdaysFragment : Fragment(R.layout.fragment_weekdays) {

    val TAG = "WeekdaysFragment"

    lateinit var scheduleViewModel: ScheduleViewModel
    private lateinit var weekdaysAdapter: WeekdaysAdapter
    val args: WeekdaysFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scheduleViewModel = (activity as MainActivity).scheduleViewModel

        val group = args.group

        weekdaysAdapter = WeekdaysAdapter()
        view.findViewById<RecyclerView>(R.id.rvWeekdays).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = weekdaysAdapter
        }
        weekdaysAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("weekday", it)
            }
            findNavController().navigate(
                R.id.action_weekdaysFragment_to_pairsFragment,
                bundle
            )
        }

        scheduleViewModel.getScheduleByGroup(group.id)
        scheduleViewModel.scheduleByGroup.observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { weekdaysResponse ->
                        weekdaysAdapter.differ.submitList(weekdaysResponse.weekdays)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occurred: $message")
                        Toast.makeText(activity, "An error occurred: $message", Toast.LENGTH_LONG)
                            .show()
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