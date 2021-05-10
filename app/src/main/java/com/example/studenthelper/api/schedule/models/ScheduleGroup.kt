package com.example.studenthelper.api.schedule.models

data class ScheduleGroup(
    val name: String,
    val weekdays: List<Weekday>
)