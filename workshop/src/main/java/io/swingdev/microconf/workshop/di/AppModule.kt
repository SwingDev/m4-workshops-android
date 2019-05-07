package io.swingdev.microconf.workshop.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesAppContext(application: Application): Context = application.applicationContext
}