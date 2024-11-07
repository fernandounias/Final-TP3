package com.example.parcial.model.model.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial.shared.infraestructure.users.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _userName = MutableStateFlow<String?>(null)
    val userName: StateFlow<String?> get() = _userName

    fun fetchUser(userId: Int) {
        viewModelScope.launch {
            val result = userRepository.getUser(userId)
            if (result.isSuccess) {
                val user = result.getOrNull()
                _userName.value = "${user?.name?.firstName?.replaceFirstChar { it.uppercase() }} ${user?.name?.lastName?.replaceFirstChar { it.uppercase() }}"
            } else {
                _userName.value = "Error fetching user"
            }
        }
    }
}
