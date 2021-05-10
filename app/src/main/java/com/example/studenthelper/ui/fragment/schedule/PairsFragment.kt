package com.example.studenthelper.ui.fragment.schedule

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.adapter.schedule.PairsAdapter
import com.example.studenthelper.dto.schedule.PairsDto
import com.example.studenthelper.ui.MainActivity
import com.example.studenthelper.ui.viewmodel.schedule.ScheduleViewModel
import com.example.studenthelper.util.Resource
import kotlinx.android.synthetic.main.fragment_weekdays.paginationProgressBar

class PairsFragment : Fragment(R.layout.fragment_pairs) {

    lateinit var scheduleViewModel: ScheduleViewModel
    private lateinit var pairsAdapter: PairsAdapter
    val args: PairsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scheduleViewModel = (activity as MainActivity).scheduleViewModel

        val pairs = args.weekday.pairs

        pairsAdapter = PairsAdapter()

        pairsAdapter.differ.submitList(pairs)

        view.findViewById<RecyclerView>(R.id.rvPairs).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = pairsAdapter
        }
    }
}
