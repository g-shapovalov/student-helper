package com.example.studenthelper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.studenthelper.R
import com.example.studenthelper.ui.viewmodel.schedule.ScheduleViewModel
import com.example.studenthelper.ui.viewmodel.schedule.ScheduleViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var scheduleViewModel: ScheduleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scheduleViewModelProviderFactory = ScheduleViewModelProviderFactory(application)
        scheduleViewModel = ViewModelProvider(this, scheduleViewModelProviderFactory).get(ScheduleViewModel::class.java)

        bottomNavigationView.setupWithNavController(studentAppNavHostFragment.findNavController())
    }
}