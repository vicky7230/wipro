package com.vicky7230.wipro.data

import com.vicky7230.wipro.data.network.AppApiHelper
import com.vicky7230.wipro.data.network.model.Response
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val appApiHelper: AppApiHelper
) : DataManager {
    override fun getData(): Observable<Response> {
        return appApiHelper.getData()
    }
}