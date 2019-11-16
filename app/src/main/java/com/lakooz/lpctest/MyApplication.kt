package com.lakooz.lpctest

import android.app.Application
import com.lakooz.lpctest.database.AppDatabase

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO: initialize database
        var db = AppDatabase.getInstance(context = applicationContext)
    }

    companion object {

        lateinit var database: AppDatabase
            private set

    }
}