package io.swingdev.microconf.mvvm.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.swingdev.microconf.mvvm.domain.CatFactsRepository
import io.swingdev.microconf.mvvm.domain.model.CatFact
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")

class CatFactsViewModel(private val repository: CatFactsRepository) : ViewModel() {
    val catFacts: LiveData<List<CatFact>> = repository.fetchCatFacts()

    fun updateData() {
        repository.updateCatFacts()
    }

    class Factory @Inject constructor(
        private val repository: CatFactsRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CatFactsViewModel(repository) as T
        }
    }
}