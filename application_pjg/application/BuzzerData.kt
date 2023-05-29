package com.example.myapplication

import com.google.gson.annotations.SerializedName


data class BuzzerData(
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("vest_num")
    val vest_num: String,
    @SerializedName("Buz")
    val Buz: String?,
    @SerializedName("BuzReason")
    val BuzReason: String?,
    @SerializedName("BuzTime")
    val BuzTime: String?

)

