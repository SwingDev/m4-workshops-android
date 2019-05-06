package io.swingdev.microconf.advancedmvvm.di

import io.swingdev.microconf.advancedmvvm.presentation.main.CatFactsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BindingsModule {
    @ContributesAndroidInjector
    fun bindsMainActivity(): CatFactsActivity
}