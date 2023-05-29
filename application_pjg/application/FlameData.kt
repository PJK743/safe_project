package com.example.myapplication

import com.google.gson.annotations.SerializedName


data class FlameData(
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("vest_num")
    val vest_num: String,
    @SerializedName("Fire")
    val Fire: String?,
    @SerializedName("FlameTime")
    val FlameTime: String?

)


