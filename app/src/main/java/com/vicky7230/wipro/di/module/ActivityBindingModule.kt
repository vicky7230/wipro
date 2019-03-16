package com.vicky7230.wipro.di.module

import com.vicky7230.wipro.ui.home.HomeActivity
import com.vicky7230.wipro.ui.home.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by vicky on 1/1/18.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity
}