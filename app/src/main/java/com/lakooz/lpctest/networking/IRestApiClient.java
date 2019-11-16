package com.lakooz.lpctest.networking;

import com.lakooz.lpctest.model.Pot;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;

interface IRestApiClient {


    @GET("/get-pots")
    fun getData() : Single<List<Pot>>


    @POST("/create-pot")
    fun createPot() : Single<Pot>
}
