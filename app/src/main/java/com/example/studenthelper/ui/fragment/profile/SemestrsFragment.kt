package com.example.studenthelper.ui.fragment.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.adapter.profile.SemestrsAdapter
import com.example.studenthelper.dto.profile.SemestrDto

class SemestrsFragment : Fragment(R.layout.fragment_semestrs) {
    private lateinit var semestAdapter: SemestrsAdapter
    private var semestersList: List<SemestrDto> = listOf(
        SemestrDto("1 курс, зимняя сессия"),
        SemestrDto("1 курс, весенняя сессия"),
        SemestrDto("2 курс, зимняя сессия"),
        SemestrDto("2 курс, весенняя сессия"),
        SemestrDto("3 курс, зимняя сессия"),
        SemestrDto("3 курс, весенняя сессия"),
        SemestrDto("4 курс, зимняя сессия"),
        SemestrDto("4 курс, весенняя сессия"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        semestAdapter = SemestrsAdapter(semestersList)

        view.findViewById<RecyclerView>(R.id.rvSemestrs).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = semestAdapter
        }

        semestAdapter.setOnItemClickListener {
            findNavController().navigate(
                R.id.action_semestrsFragment_to_subjectsFragment
            )
        }
    }
}