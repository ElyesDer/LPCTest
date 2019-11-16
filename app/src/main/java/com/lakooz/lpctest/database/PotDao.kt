package com.lakooz.lpctest.database

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lakooz.lpctest.model.Pot


@Dao
abstract class PotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun createOrUpdate(pot: Pot)

    fun insertAllAndSynchronize(pots: List<Pot>) {
        doAsync {
            pots.forEach {
                Log.e("TAG", "insertAllAndSynchronize: $it")
                createOrUpdate(it)
            }
        }.execute()
    }

    @Query("SELECT * FROM Pot WHERE category = :category ")
    abstract fun getPots(category: Int): LiveData<List<Pot>>

    class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            handler()
            return null
        }
    }
}