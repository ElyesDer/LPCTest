package com.lakooz.lpctest.networking

import com.lakooz.lpctest.model.Pot
import io.reactivex.Single
import retrofit2.http.*

interface IRestApiClient {

    @GET("get-pots")
    fun getData() : Single<List<Pot>>

    @FormUrlEncoded
    @POST("create-pot")
    fun createPot(@Field("category") category : Int) : Single<Pot>
}