package com.example.studenthelper.ui.fragment.schedule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studenthelper.R
import com.example.studenthelper.adapter.schedule.WeekdaysAdapter
import com.example.studenthelper.dto.schedule.WeekDaysDto
import kotlinx.android.synthetic.main.fragment_weekdays.*

class WeekdaysFragment : Fragment(R.layout.fragment_weekdays) {

    private lateinit var weekdaysAdapter: WeekdaysAdapter

    private var weekdaysList: List<WeekDaysDto> = listOf(
        WeekDaysDto("Понедельник"),
        WeekDaysDto("Вторник"),
        WeekDaysDto("Среда"),
        WeekDaysDto("Четверг"),
        WeekDaysDto("Пятница"),
        WeekDaysDto("Суббота"),
        WeekDaysDto("Воскресенье"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weekdaysAdapter = WeekdaysAdapter(weekdaysList)

        rvWeekdays.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = weekdaysAdapter
        }

        weekdaysAdapter.setOnItemClickListener {
            findNavController().navigate(
                R.id.action_weekdaysFragment_to_pairsFragment
            )
        }
    }
}