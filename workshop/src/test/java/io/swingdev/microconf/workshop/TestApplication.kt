package io.swingdev.microconf.workshop

import io.swingdev.microconf.workshop.di.AppInjector

class TestApplication: MainApplication() {

    // TODO: Assign AppInjector after build
    override lateinit var appInjector: AppInjector
}