package com.example.midterm2.activities.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.midterm2.model.User
import com.example.midterm2.repo.UserRepo
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val userRepo = UserRepo()

    private val _users: MutableLiveData<List<User>> = MutableLiveData(listOf())
    val users: LiveData<List<User>> = _users

    fun loadUsers() {
        viewModelScope.launch {
            _users.postValue(userRepo.loadUsers())
        }
    }
}