package com.example.tuts.model
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email:String,
    @SerializedName("name")
    val name: String,
    @SerializedName("avatar")
    val avatar: String
)