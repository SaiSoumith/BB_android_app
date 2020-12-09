package com.example.userapp.models


import com.google.gson.annotations.SerializedName

data class ProductX(
    @SerializedName("height")
    val height: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("length")
    val length: String,
    @SerializedName("tonnage")
    val tonnage: String,
    @SerializedName("truckRegNum")
    val truckRegNum: String,
    @SerializedName("bodyType")
    val bodyType: String
)
