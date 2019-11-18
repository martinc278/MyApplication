package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BottleService {
    @GET("cellars/{cellarId}/bottles")
    fun getBottles(@Path("cellarId") cellarId: String): Call<List<Bottle>>

    @POST("cellars/{cellarID}/bottles")
    fun createBottle(@Path("cellarID") cellarId: String, @Body bottle: Bottle)
}