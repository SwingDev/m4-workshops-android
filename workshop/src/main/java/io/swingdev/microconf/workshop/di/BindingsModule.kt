package io.swingdev.microconf.workshop.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.swingdev.microconf.workshop.presentation.main.CatFactsActivity

@Module
interface BindingsModule {
    @ContributesAndroidInjector
    fun bindsMainActivity(): CatFactsActivity
}