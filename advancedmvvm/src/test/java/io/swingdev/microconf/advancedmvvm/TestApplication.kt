package io.swingdev.microconf.advancedmvvm

import io.swingdev.microconf.advancedmvvm.di.AppInjector
import io.swingdev.microconf.advancedmvvm.di.DaggerTestAppInjector

class TestApplication : MainApplication() {

    override val appInjector: AppInjector
        get() = DaggerTestAppInjector.builder()
            .application(this)
            .build()
}