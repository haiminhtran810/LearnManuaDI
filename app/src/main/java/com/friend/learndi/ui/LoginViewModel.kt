package com.friend.learndi.ui

import androidx.lifecycle.ViewModel
import com.friend.learndi.data.UserRepository

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun getName() {
        userRepository.getName()
    }
}