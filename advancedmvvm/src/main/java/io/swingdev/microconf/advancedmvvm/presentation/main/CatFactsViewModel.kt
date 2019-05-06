package io.swingdev.microconf.advancedmvvm.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.swingdev.microconf.advancedmvvm.domain.CatFactsRepository
import io.swingdev.microconf.advancedmvvm.domain.model.CatFact
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CatFactsViewModel @Inject constructor(
    private val repository: CatFactsRepository
) : ViewModel() {
    val catFacts = MutableLiveData<List<CatFact>>()
    val errorHandler = MutableLiveData<Throwable>()

    private val compositeDisposable = CompositeDisposable()

    init {
        repository.fetchCatFacts()
            .subscribeBy(onError = {
                errorHandler.postValue(it)
            }, onNext = {
                catFacts.postValue(it)
            }).addTo(compositeDisposable)
    }

    fun updateData() {
        repository.updateFacts()
            .subscribeBy(onError = {
                errorHandler.postValue(it)
            }, onNext = {
                catFacts.postValue(it)
            }).addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}