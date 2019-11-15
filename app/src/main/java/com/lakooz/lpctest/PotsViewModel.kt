package com.lakooz.lpctest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lakooz.lpctest.model.Pot
import com.lakooz.lpctest.repositories.PotRepository

class PotsViewModel() : ViewModel() {

    private val repository = PotRepository.instance

    // TODO : initialize
    var pots: LiveData<List<Pot>>

    init {
        pots = repository.getPots() // by default equal 0 so change depend on
    }

    fun loadPots() {
        // todo async request
        pots = repository.getPots()
    }


}