package io.swingdev.microconf.mvvm

import android.app.Application
import io.swingdev.microconf.mvvm.di.*
import javax.inject.Inject

class MainApplication : Application() {
    @Inject
    lateinit var injector: AppInjector

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAppInjector.builder()
            .appModule(AppModule(this))
            .databaseModule(DatabaseModule())
            .networkModule(NetworkModule())
            .build()
    }
}