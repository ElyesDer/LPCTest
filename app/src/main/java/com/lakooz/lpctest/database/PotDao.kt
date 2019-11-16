package com.lakooz.lpctest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lakooz.lpctest.model.Pot


@Dao
interface PotDao {

    //TODO
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createOrUpdate(pot: Pot) {

    }

    // TODO : add missing methods


    // some select , insert


    @Query("SELECT * from Pot")
    fun getAll(): List<Pot>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pot: Pot)

    fun insertAllAndSynchronize(pots: List<Pot>) {

    }

    fun getPots(category: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}