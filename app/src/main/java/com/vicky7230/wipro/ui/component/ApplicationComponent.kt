package com.vicky7230.wipro.ui.component

import com.vicky7230.wipro.di.module.ActivityBindingModule
import com.vicky7230.wipro.di.module.ViewModelModule
import com.vicky7230.wipro.WiproApplication
import com.vicky7230.wipro.di.module.ApplicationModule
import com.vicky7230.wipro.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(wiproApplication: WiproApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(wiproApplication: WiproApplication)
}
