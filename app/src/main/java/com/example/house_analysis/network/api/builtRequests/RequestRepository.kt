package com.example.house_analysis.network.api.builtRequests

import com.example.house_analysis.network.api.ApiService
import com.example.house_analysis.network.api.RequestRepositoryProvider
import com.example.house_analysis.network.model.request.UserLoginData
import com.example.house_analysis.network.model.request.UserRegisterData
import com.example.house_analysis.network.model.response.TasksResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RequestRepository {
    private val networkRepository = RequestRepositoryProvider.provideRequestRepository()
    private val networkPostRepo = PostRequestsRepo(networkRepository)
    private val networkGetRepo = GetRequestsRepo(networkRepository)

    suspend fun login(userInfo: UserLoginData): Boolean {
        return networkPostRepo.login(userInfo)
    }

    suspend fun register(userInfo: UserRegisterData): Int {
        return networkPostRepo.registration(userInfo)
    }

    suspend fun getTasks(): ArrayList<TasksResponse> {
        return networkGetRepo.getTasks()
    }



}