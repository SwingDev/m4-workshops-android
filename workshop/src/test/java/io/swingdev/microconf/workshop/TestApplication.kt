package io.swingdev.microconf.workshop

import io.swingdev.microconf.workshop.di.AppInjector
import io.swingdev.microconf.workshop.di.DaggerTestAppInjector

class TestApplication : MainApplication() {

    override val appInjector: AppInjector by lazy {
        DaggerTestAppInjector.builder()
            .application(this)
            .build()
    }
}