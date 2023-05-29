package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface Apiservice5 {

    @GET("/moblie/Led")



    fun getLightData(): Call<Map<String, Any>>

}

