package io.swingdev.microconf.advancedmvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.swingdev.microconf.advancedmvvm.di.annotation.ViewModelKey
import io.swingdev.microconf.advancedmvvm.presentation.main.CatFactsViewModel
import io.swingdev.microconf.advancedmvvm.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CatFactsViewModel::class)
    fun bindsMainViewModel(catFactsViewModel: CatFactsViewModel): ViewModel
}