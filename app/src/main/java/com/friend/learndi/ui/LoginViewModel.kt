package com.friend.learndi.ui

import androidx.lifecycle.ViewModel
import com.friend.learndi.data.UserRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    fun getStringName(): String? {
        return userRepository.getStringName()
    }
}