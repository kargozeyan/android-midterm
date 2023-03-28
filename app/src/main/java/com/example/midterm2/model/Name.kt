package com.example.midterm2.model

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("first")
    val first: String,

    @SerializedName("last")
    val last: String
)