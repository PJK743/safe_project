package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class GasData(
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("vest_num")
    val vest_num: String,
    @SerializedName("Gas")
    val Gas: String?,
    @SerializedName("GasTime")
    val GasTime: String?

)

