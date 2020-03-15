package com.friend.learndi.ui

import com.friend.learndi.data.LoginUserData
import com.friend.learndi.data.UserRepository
import com.friend.learndi.di.LoginViewModelFactory

class LoginContainer(private val userRepository: UserRepository) {
    val loginData = LoginUserData()
    val loginViewModelFactory = LoginViewModelFactory(userRepository)
}