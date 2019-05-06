package io.swingdev.microconf.mvc.di

import io.swingdev.microconf.mvc.presentation.main.CatFactsActivity
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