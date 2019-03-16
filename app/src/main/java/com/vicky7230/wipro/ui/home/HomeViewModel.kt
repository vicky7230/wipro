package com.vicky7230.wipro.ui.home

import androidx.lifecycle.ViewModel
import com.vicky7230.wipro.data.DataManager
import com.vicky7230.wipro.data.network.model.Response
import io.reactivex.Observable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val dataManager: DataManager
) : ViewModel() {

    fun getData(query: String, page: Int): Observable<Response> {
        return dataManager.getData()
    }
}
