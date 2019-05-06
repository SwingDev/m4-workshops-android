package io.swingdev.microconf.advancedmvvm.di

import android.app.Application
import io.swingdev.microconf.advancedmvvm.suite.CatFactsTest
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
        TestDatabaseModule::class,
        TestNetworkModule::class,
        ViewModelModule::class
    ]
)
interface TestAppInjector : AppInjector {
    fun inject(test: CatFactsTest)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TestAppInjector
    }
}