package com.example.studenthelper.api.schedule

import com.example.studenthelper.api.schedule.models.InitResponse
import com.example.studenthelper.api.schedule.models.Schedule
import com.example.studenthelper.api.schedule.models.ScheduleGroup
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ScheduleApi {

    @GET("api/init")
    suspend fun init(
        @Query(value = "application_id")
        applicationId: Int = 228,
    ): Response<InitResponse>

    @GET("api/schedule")
    suspend fun getSchedule(
        @Query(value = "application_id")
        applicationId: Int = 228,
    ): Response<Schedule>

    @GET("api/groups/schedule")
    suspend fun getScheduleByGroup(
        @Query(value = "application_id")
        applicationId: Int = 228,
        @Query(value = "group_id")
        groupId: Int
    ): Response<ScheduleGroup>

}