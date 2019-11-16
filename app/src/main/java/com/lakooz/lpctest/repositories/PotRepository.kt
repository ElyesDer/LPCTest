package com.lakooz.lpctest.repositories

import androidx.lifecycle.LiveData
import com.lakooz.lpctest.MyApplication
import com.lakooz.lpctest.database.PotDao
import com.lakooz.lpctest.model.Pot

class PotRepository(
    private val potDao: PotDao
) {

    fun createOrUpdate(pot: Pot) {
        potDao.createOrUpdate(pot)
    }

    fun insertAllAndSynchronize(pots: List<Pot>) {
        potDao.insertAllAndSynchronize(pots)
    }

    fun getPots(category: Int): LiveData<List<Pot>> = potDao.getPots(category)


    companion object {
        // TODO : initialize
        val instance: PotRepository = PotRepository(MyApplication.database.getDao())
    }

}