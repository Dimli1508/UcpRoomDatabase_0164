package com.example.ucp2.ui.viewmodel

import MataKuliah
import MataKuliahRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MataKuliahViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MataKuliahRepository
    val allMataKuliah: LiveData<List<MataKuliah>>


    init {
        val mataKuliahDao = database.getDatabase(application).MataKuliahDao()
        repository = MataKuliahRepository(mataKuliahDao)
        allMataKuliah = repository.allMataKuliah
    }

    fun insert(mataKuliah: MataKuliah) = viewModelScope.launch {
        repository.insert(mataKuliah)
    }

    fun update(mataKuliah: MataKuliah) = viewModelScope.launch {
        repository.update(mataKuliah)
    }

    fun delete(mataKuliah: MataKuliah) = viewModelScope.launch {
        repository.delete(mataKuliah)
    }
}
