package com.lakooz.lpctest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lakooz.lpctest.model.Pot
import androidx.lifecycle.MutableLiveData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.lakooz.lpctest.database.AppDatabase
import com.lakooz.lpctest.repositories.PotRepository


class PotsViewModel : ViewModel() {


    // TODO : initialize
    val pots: LiveData<List<Pot>>? = null
    private val repository = PotRepository.instance
    private var potRepository: PotRepository? = MyApplication.potRepository

    fun init() {
        if (pots != null) {
            return
        }
        potRepository = potRepository

    }


}