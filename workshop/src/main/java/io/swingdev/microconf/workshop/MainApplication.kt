package io.swingdev.microconf.workshop

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.swingdev.microconf.workshop.di.AppInjector
import javax.inject.Inject

open class MainApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    // TODO: Assign AppInjector after build
    open lateinit var appInjector: AppInjector

    override fun onCreate() {
        super.onCreate()

        // TODO: Inject MainApplication
    }

    override fun activityInjector(): AndroidInjector<Activity> = injector
}