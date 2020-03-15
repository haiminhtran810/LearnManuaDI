package com.friend.learndi.di

import com.friend.learndi.data.UserRepository
import com.friend.learndi.ui.LoginViewModel

interface Factory {
    fun create(): Any
}

class LoginViewModelFactory(private val userRepository: UserRepository) : Factory {
    override fun create(): LoginViewModel {
        return LoginViewModel(userRepository)
    }
}