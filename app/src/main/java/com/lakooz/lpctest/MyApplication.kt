package com.lakooz.lpctest

import android.app.Application
import android.content.Context
import com.lakooz.lpctest.database.AppDatabase
import com.lakooz.lpctest.networking.IRestApiClient
import com.lakooz.lpctest.networking.RestApiClient
import com.lakooz.lpctest.repositories.PotRepository
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        // TODO: initialize database
        database = AppDatabase.getInstance(context = applicationContext)


    }

    companion object {

        lateinit var database: AppDatabase
            private set

    }
}