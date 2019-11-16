package com.lakooz.lpctest

import android.app.Application
import androidx.room.Room
import com.lakooz.lpctest.database.AppDatabase
import com.lakooz.lpctest.networking.RestApiClient
import com.lakooz.lpctest.repositories.PotRepository
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO: initialize database
        var db = AppDatabase.getInstance(context = applicationContext)
        db.getDao()

        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://randomapi.com/api/")
            .build()

        potApi = retrofit.create(RestApiClient::class.java)
        appDatabase = db

        potRepository = PotRepository(potApi, appDatabase.getDao())
        mainViewModel = MainViewModel(potRepository)

    }

    companion object {

        // lets instanciate all the stuf
        lateinit var retrofit: Retrofit
        lateinit var potApi: RestApiClient
        lateinit var potRepository: PotRepository
        lateinit var mainViewModel: MainViewModel
        lateinit var appDatabase: AppDatabase

        fun injectPotApi() = potApi

        fun injectMainViewModel() = mainViewModel

        fun injectPotDao() = appDatabase.getDao()

    }
}