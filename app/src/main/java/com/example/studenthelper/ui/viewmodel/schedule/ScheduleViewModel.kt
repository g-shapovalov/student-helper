package com.example.studenthelper.ui.viewmodel.schedule

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.studenthelper.api.schedule.RetrofitInstance
import com.example.studenthelper.api.schedule.models.InitResponse
import com.example.studenthelper.api.schedule.models.Schedule
import com.example.studenthelper.api.schedule.models.ScheduleGroup
import com.example.studenthelper.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ScheduleViewModel(
    app: Application,
) : AndroidViewModel(app) {

    val groups: MutableLiveData<Resource<InitResponse>> = MutableLiveData()
    val schedule: MutableLiveData<Resource<Schedule>> = MutableLiveData()
    val scheduleByGroup: MutableLiveData<Resource<ScheduleGroup>> = MutableLiveData()

    init {
        getGroups()
    }

    fun getGroups() = viewModelScope.launch {
        groups.postValue(Resource.Loading())
        val response = RetrofitInstance.scheduleApi.init()
        groups.postValue(handleGroupsResponse(response))
    }

    private fun handleGroupsResponse(response: Response<InitResponse>) : Resource<InitResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun getSchedule() = viewModelScope.launch {
        schedule.postValue(Resource.Loading())
        val response = RetrofitInstance.scheduleApi.getSchedule()
        schedule.postValue(handleScheduleResponse(response))
    }

    private fun handleScheduleResponse(response: Response<Schedule>) : Resource<Schedule> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun getScheduleByGroup(groupId: Int) = viewModelScope.launch {
        scheduleByGroup.postValue(Resource.Loading())
        val response = RetrofitInstance.scheduleApi.getScheduleByGroup(groupId = groupId)
        scheduleByGroup.postValue(handleScheduleByGroupResponse(response))
    }

    private fun handleScheduleByGroupResponse(response: Response<ScheduleGroup>) : Resource<ScheduleGroup> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}