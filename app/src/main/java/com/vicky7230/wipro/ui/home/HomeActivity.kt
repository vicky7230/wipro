package com.vicky7230.wipro.ui.home

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.vicky7230.wipro.R
import com.vicky7230.wipro.data.network.model.Response
import com.vicky7230.wipro.data.network.model.Row
import com.vicky7230.wipro.ui.base.BaseActivity
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.list_item.view.*
import timber.log.Timber
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var compositeDisposable: CompositeDisposable
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager
    @Inject
    lateinit var dataAdapter: DataAdapter

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeViewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModel::class.java]

        init()
    }

    private fun init() {
        setSupportActionBar(toolbar as Toolbar?)

        pull_to_refresh.setOnRefreshListener {
            dataAdapter.clearItems()
            loadData()
        }

        data_list.layoutManager = linearLayoutManager
        data_list.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        data_list.adapter = dataAdapter


        //this will make sure we don't make redundant network requests when device screen is rotated
        if (homeViewModel.getResponse() == null) {
            pull_to_refresh.isRefreshing = true
            loadData()
        } else {
            supportActionBar?.title = homeViewModel.getResponse()?.title
            dataAdapter.addItems(homeViewModel.getResponse()?.rows as MutableList<Row>?)
        }
    }

    private fun loadData() {
        compositeDisposable.add(
            homeViewModel.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response: Response? ->
                    pull_to_refresh.isRefreshing = false
                    supportActionBar?.title = response?.title
                    if (response?.rows != null && response.rows?.size?.compareTo(0) != 0) {
                        homeViewModel.setResponse(response)
                        dataAdapter.addItems(response.rows as MutableList<Row>?)
                    }
                }, { throwable ->
                    pull_to_refresh.isRefreshing = false
                    showMessage(throwable.message)
                    Timber.e(throwable)
                })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

}
