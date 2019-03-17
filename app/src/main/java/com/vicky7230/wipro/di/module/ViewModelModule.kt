package com.vicky7230.wipro.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vicky7230.wipro.ViewModelFactory
import com.vicky7230.wipro.di.ViewModelKey
import com.vicky7230.wipro.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun postHomeViewModel(viewModel: HomeViewModel): ViewModel

}