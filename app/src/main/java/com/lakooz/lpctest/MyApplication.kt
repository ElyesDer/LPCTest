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
        var db = AppDatabase.getInstance(context = applicationContext)
        db.getDao()

        appDatabase = db

        potRepository = PotRepository( appDatabase.getDao())
        mainViewModel = MainViewModel(this, potRepository)

    }

    companion object {

        // lets instanciate all the stuf
        lateinit var retrofit: Retrofit
        lateinit var potApi: IRestApiClient
        lateinit var potRepository: PotRepository
        lateinit var mainViewModel: MainViewModel
        lateinit var appDatabase: AppDatabase


    }
}