package com.vicky7230.wipro.data.network

import com.vicky7230.wipro.data.network.model.Response
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getData(): Observable<Response> {
        return apiService.getData()
    }

}