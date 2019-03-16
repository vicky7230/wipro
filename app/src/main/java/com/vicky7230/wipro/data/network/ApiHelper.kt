package com.vicky7230.wipro.data.network

import com.vicky7230.wipro.data.network.model.Response
import io.reactivex.Observable

interface ApiHelper {

    fun getData(): Observable<Response>
}