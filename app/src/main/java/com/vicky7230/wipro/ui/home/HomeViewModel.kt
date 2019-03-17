package com.vicky7230.wipro.ui.home

import androidx.lifecycle.ViewModel
import com.vicky7230.wipro.data.DataManager
import com.vicky7230.wipro.data.network.model.Response
import com.vicky7230.wipro.data.network.model.Row
import io.reactivex.Observable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val dataManager: DataManager
) : ViewModel() {

    private var response: Response? = null

    fun getData(): Observable<Response> {
        return dataManager.getData()
    }

    fun getResponse(): Response? {
        return response
    }

    fun setResponse(response: Response?) {
        this.response = response
    }
}
