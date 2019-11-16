package com.lakooz.lpctest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lakooz.lpctest.model.Pot


@Dao
abstract class PotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun createOrUpdate(pot: Pot)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAllAndSynchronize(pots: List<Pot>)

    @Query("SELECT * FROM Pot WHERE category = :cat ORDER BY creatuibDate ")
    abstract fun getPots(cat: Int)


/*
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
*/

}