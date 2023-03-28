package com.example.midterm2.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("results")
    val results : List<User>
)