package com.example.studenthelper.ui.fragment.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.adapter.profile.SubjectsAdapter
import com.example.studenthelper.dto.profile.SubjectDto

class SubjectsFragment : Fragment(R.layout.fragment_subjects) {
    private lateinit var subjectAdapter: SubjectsAdapter
    private var subjectsList: List<SubjectDto> = listOf(
        SubjectDto(
            "Математический анализ",
            "+",
            "6"
        ),
        SubjectDto(
            "Общая физика",
            "+",
            "7"
        ),
        SubjectDto(
            "Иностранный язык",
            "+",
            ""
        ),
        SubjectDto(
            "Иностранный язык (русский)",
            "зачет",
            ""
        ),
        SubjectDto(
            "Интегрированный модуль \"История\"",
            "+",
            ""
        ),
        SubjectDto(
            "Интегрированный модуль \"Политология\"",
            "+",
            ""
        ),
        SubjectDto(
            "Программирование",
            "+",
            ""
        ),
        SubjectDto(
            "Физическая культура",
            "+",
            ""
        ),
        SubjectDto(
            "Аналитическая геометрия и линейная алгебра",
            "",
            "7"
        ),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subjectAdapter = SubjectsAdapter(subjectsList)

        view.findViewById<RecyclerView>(R.id.rvSubjects).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = subjectAdapter
        }
    }
}
