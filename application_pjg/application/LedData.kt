package com.example.myapplication

import com.google.gson.annotations.SerializedName


data class LedData(
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("vest_num")
    val vest_num: String,
    @SerializedName("OnOff")
    val OnOff: String?,
    @SerializedName("LedTime")
    val LedTime: String?

)

