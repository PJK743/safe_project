package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface Apiservice2 {

    @GET("/moblie/Buzzer")



    fun getBuzzerData(): Call<Map<String, Any>>

}
