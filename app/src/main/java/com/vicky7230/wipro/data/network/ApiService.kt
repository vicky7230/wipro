package com.vicky7230.wipro.data.network

import com.vicky7230.wipro.data.network.model.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getData(): Observable<Response>

}