package com.example.studenthelper.util

import java.lang.IllegalArgumentException

enum class Weekdays(val code: Int, val rus: String) {

    MONDAY(0, "Понедельник"),
    TUESDAY(1, "Вторник"),
    WEDNESDAY(2, "Среда"),
    THURSDAY(3, "Четверг"),
    FRIDAY(4, "Пятница"),
    SATURDAY(5, "Суббота"),
    SUNDAY(6, "Воскресенье");

    companion object {
        fun getByCode(code: Int): Weekdays = values().find { it.code == code }
            ?: throw IllegalArgumentException("No Weekdays enum value for code $code")
    }
}