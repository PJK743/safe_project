package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class TempHmData(
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("vest_num")
    val vest_num: String,
    @SerializedName("Temp")
    val Temp: String?,
    @SerializedName("Hm")
    val Hm: String?,
    @SerializedName("TempHmTime")
    val TempHmTime: String?

)

