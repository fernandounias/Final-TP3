package com.example.parcial.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial.model.users.IUser
import com.example.parcial.model.users.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val userImpl: IUser
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun getUser(userId: Int) {
        viewModelScope.launch {
            _user.value = userImpl.getUser(userId)
        }
    }
}