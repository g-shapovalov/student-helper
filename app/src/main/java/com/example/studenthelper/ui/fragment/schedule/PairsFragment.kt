package com.example.studenthelper.ui.fragment.schedule

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthelper.R
import com.example.studenthelper.adapter.schedule.PairsAdapter
import com.example.studenthelper.dto.schedule.PairsDto

class PairsFragment : Fragment(R.layout.fragment_pairs) {
    private lateinit var pairsAdapter: PairsAdapter
    private var pairsList: List<PairsDto> = listOf(
        PairsDto(
            "Модели даннных и СУБД",
            "laboratory",
            "Скакун В.В",
            "9:00",
            "194",
        ),
        PairsDto(
            "Технические средства защиты информации",
            "seminar",
            "Дуль Ольга Петровна",
            "10:30",
            "227"
        ),
        PairsDto(
            "Оптоэлектроника",
            "lection",
            "Демидчик Валерий Иосифович",
            "12:00",
            "226"
        ),
        PairsDto(
            "Интерфейсы передачи данных",
            "lection",
            "Демидчик Валерий Иосифович",
            "13:20",
            "107"
        ),
        PairsDto(
            "ПАСОИБ",
            "practice",
            "Дуль Ольга Петровна",
            "15:20",
            "118"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pairsAdapter = PairsAdapter(pairsList)

        view.findViewById<RecyclerView>(R.id.rvPairs).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = pairsAdapter
        }
    }
}
