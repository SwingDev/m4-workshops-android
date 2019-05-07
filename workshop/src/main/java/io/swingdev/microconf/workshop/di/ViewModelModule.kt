package io.swingdev.microconf.workshop.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import io.swingdev.microconf.workshop.utils.ViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    // TODO: Bind CatFactViewModel
}