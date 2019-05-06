package io.swingdev.microconf.mvvm.di

import io.swingdev.microconf.mvvm.presentation.main.CatFactsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class
    ]
)
interface AppInjector {
    fun inject(activity: CatFactsActivity)
}