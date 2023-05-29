package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface Apiservice4 {

    @GET("/moblie/Ligth")



    fun getLedData(): Call<Map<String, Any>>

}

