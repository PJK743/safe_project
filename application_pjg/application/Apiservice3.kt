package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface Apiservice3 {

    @GET("/moblie/Gas")



    fun getGasData(): Call<Map<String, Any>>

}
