package com.example.myapplication

import com.google.gson.annotations.SerializedName


data class LightData(
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("vest_num")
    val vest_num: String,
    @SerializedName("Light")
    val Light: String?,
    @SerializedName("LightTime")
    val LightTime: String?

)

