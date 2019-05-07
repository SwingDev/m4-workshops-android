package io.swingdev.microconf.workshop.presentation.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

// TODO: Inject constructor
class CatFactsViewModel constructor() : ViewModel() {
    // TODO: Declare CatFacts list

    // TODO: Declare Error Handler

    private val compositeDisposable = CompositeDisposable()

    init {
        // TODO: Fetch data from repository
    }

    fun updateData() {
        // TODO: Update data from repository
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}