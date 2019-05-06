package io.swingdev.microconf.mvc

import android.app.Application
import io.swingdev.microconf.mvc.di.*

class MainApplication : Application() {
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