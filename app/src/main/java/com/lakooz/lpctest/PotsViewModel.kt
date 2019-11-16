package com.lakooz.lpctest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lakooz.lpctest.model.Pot
import com.lakooz.lpctest.repositories.PotRepository

class PotsViewModel(repository: PotRepository) : ViewModel() {

    private val repository = repository

    // TODO : initialize
    val pots: LiveData<List<Pot>>? = null

}