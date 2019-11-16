package com.lakooz.lpctest.networking

import com.lakooz.lpctest.model.Pot
import com.lakooz.lpctest.repositories.PotRepository
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestApiClient {

    private const val BASE_URL = "https://recrutement.lepotcommuntest.fr/2019/recruiting/"


    fun getPots(): Single<List<Pot>> {
        return RestAPI.invoke().getPots()
    }

    fun createPot(category: Int): Single<Pot> {
        return RestAPI.invoke().createPot()
    }

    object RestAPI {
        operator fun invoke(): RestApiClient {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApiClient::class.java)
        }
    }

}