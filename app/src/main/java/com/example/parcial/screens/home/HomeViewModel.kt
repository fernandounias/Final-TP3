package com.example.parcial.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.parcial.screens.user.UserViewModel

class HomeViewModel(
    private val userViewModel: UserViewModel // Dependencia que necesita el HomeViewModel
) : ViewModel() {

    private val _userName = MutableStateFlow<String?>(null)
    val userName: StateFlow<String?> = _userName

    init {
        viewModelScope.launch {
            userViewModel.user.collect { user ->
                _userName.value = user?.name?.firstName
            }
        }
    }

    companion object {
        fun provideFactory(userViewModel: UserViewModel): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return HomeViewModel(userViewModel) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
    }
}
