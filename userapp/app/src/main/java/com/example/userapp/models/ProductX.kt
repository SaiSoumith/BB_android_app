package com.example.userapp.models


import com.google.gson.annotations.SerializedName

data class ProductX(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("school")
    val school: String
)