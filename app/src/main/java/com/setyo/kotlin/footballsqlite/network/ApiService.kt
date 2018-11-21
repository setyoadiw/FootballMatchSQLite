package com.setyo.kotlin.footballsqlite.network

import com.setyo.kotlin.footballsqlite.model.EventSchedule.ResponseLastEvents
import com.setyo.kotlin.footballsqlite.model.TeamDetail.ResponseTeamDetail
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


//    @GET("/api/v1/json/1/eventspastleague.php?id=4328")
//    fun getLastSchedule(): Observable<ResponseLastEvents>

    @GET("eventspastleague.php?id=4328")
    fun getLastSchedule(): Observable<ResponseLastEvents>

//    @GET("/api/v1/json/1/eventsnextleague.php?id=4328")
//    fun getNextSchedule(): Observable<ResponseLastEvents>

    @GET("eventsnextleague.php?id=4328")
    fun getNextSchedule(): Observable<ResponseLastEvents>

//    @GET("/api/v1/json/1/lookupteam.php?")
//    fun getTeamDetail(@Query("id") id: String): Observable<ResponseTeamDetail>

    @GET("lookupteam.php?")
    fun getTeamDetail(@Query("id") id: String): Observable<ResponseTeamDetail>





}