package com.lakooz.lpctest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lakooz.lpctest.model.Pot


// TODO : Done
@Database(entities = arrayOf(Pot::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    //TODO ! done declaring the thin DAO intefcae

    abstract fun getDao(): PotDao

    companion object {

        private const val DATABASE_NAME = "db_lpc_test"
        private var instance: AppDatabase? = null


        // TODO : implement
        fun buildDatabase(context: Context): AppDatabase {

            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
            }
            return instance!!

        }

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    if (instance == null) {
                        instance =
                            buildDatabase(context.applicationContext)
                    }
                }
            }
            return instance!!
        }

    }
}