package io.swingdev.microconf.workshop

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.swingdev.microconf.workshop.di.AppInjector
import io.swingdev.microconf.workshop.di.DaggerAppInjector
import javax.inject.Inject

open class MainApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    open val appInjector: AppInjector by lazy {
        DaggerAppInjector.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        appInjector.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = injector
}