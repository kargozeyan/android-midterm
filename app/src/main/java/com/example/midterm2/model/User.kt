package com.example.midterm2.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,

    @SerializedName("name")
    val name: Name,

    @SerializedName("nat")
    val nationality: String
)