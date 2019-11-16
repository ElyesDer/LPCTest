package com.lakooz.lpctest.repositories

import com.lakooz.lpctest.database.AppDatabase
import com.lakooz.lpctest.database.PotDao
import com.lakooz.lpctest.model.Pot

class PotRepository(private val potDao: PotDao) {

    fun createOrUpdate(pot: Pot) {
        potDao.createOrUpdate(pot)
    }

    fun insertAllAndSynchronize(pots: List<Pot>) {
        potDao.insertAllAndSynchronize(pots)
    }

    fun getPots(category: Int = 0) = potDao.getPots(category)

    /*
    get rid of this instantiator and instanciate from caller : to try
    companion object {
        // TODO : initialize
        val instance : PotRepository = PotRepository(AppDatabase.getDao())
    }
*/
}