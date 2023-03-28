package com.example.midterm2.repo

import com.example.midterm2.model.User
import com.example.midterm2.service.RetrofitHelper

class UserRepo {
    private val userService = RetrofitHelper.userService;

    suspend fun loadUsers(): List<User> {
        return userService.getUsers().results ?: emptyList()
    }

}