package com.setyo.kotlin.footballsqlite.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    var retrofit = Retrofit.Builder()

//            .baseUrl("https://private-044be-dicodingfootball.apiary-mock.com")
            .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    var service = retrofit.create<ApiService>(ApiService::class.java!!)

}