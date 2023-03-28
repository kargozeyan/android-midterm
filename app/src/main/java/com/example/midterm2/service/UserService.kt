package com.example.midterm2.service

import com.example.midterm2.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("?inc=nat,name,email&results=100")
    suspend fun getUsers(): ApiResponse
}