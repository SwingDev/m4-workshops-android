package io.swingdev.microconf.workshop.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.swingdev.microconf.workshop.di.annotation.ViewModelKey
import io.swingdev.microconf.workshop.presentation.main.CatFactsViewModel
import io.swingdev.microconf.workshop.utils.ViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CatFactsViewModel::class)
    fun bindsCatFactsViewModel(catFactsViewModel: CatFactsViewModel): ViewModel
}