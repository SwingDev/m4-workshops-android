package io.swingdev.microconf.advancedmvvm.di

import android.app.Application
import io.swingdev.microconf.advancedmvvm.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        BindingsModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ViewModelModule::class
    ]
)
interface AppInjector {
    fun inject(application: MainApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppInjector
    }
}