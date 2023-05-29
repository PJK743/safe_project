package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //@GET("insert/test")
    @GET("/moblie/Flame")

    fun getFlameData(): Call<Map<String, Any>>

}