package com.vicky7230.wipro.di.module

import android.app.Application
import android.content.Context
import com.vicky7230.wipro.WiproApplication
import com.vicky7230.wipro.data.AppDataManager
import com.vicky7230.wipro.data.Config
import com.vicky7230.wipro.data.DataManager
import com.vicky7230.wipro.data.network.ApiHelper
import com.vicky7230.wipro.data.network.AppApiHelper
import com.vicky7230.wipro.di.ApplicationContext
import com.vicky7230.wipro.di.BaseUrl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by vicky on 31/12/17.
 */
@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    internal fun provideContext(wiproApplication: WiproApplication): Context {
        return wiproApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(wiproApplication: WiproApplication): Application {
        return wiproApplication
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }


    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String {
        return Config.BASE_URL
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }
}