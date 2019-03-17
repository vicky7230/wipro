package com.vicky7230.wipro.ui.home

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vicky7230.wipro.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    fun provideLinearLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
        return LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
    }

    @Provides
    fun provideDataAdapter(): DataAdapter {
        return DataAdapter(arrayListOf())
    }
}
