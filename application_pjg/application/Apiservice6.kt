package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface Apiservice6 {

    @GET("/moblie/TempHm")



    fun getTempHmData(): Call<Map<String, Any>>

}

