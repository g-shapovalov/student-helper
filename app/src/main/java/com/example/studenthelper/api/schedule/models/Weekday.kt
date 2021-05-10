package com.example.studenthelper.api.schedule.models

import java.io.Serializable

data class Weekday(
    val number: Int,
    val pairs: List<Pair>
): Serializable