package io.swingdev.microconf.advancedmvvm.di

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