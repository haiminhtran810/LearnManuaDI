package com.friend.learndi.ui

import androidx.lifecycle.ViewModel
import com.friend.learndi.data.UserRepository
import com.friend.learndi.di.ActivityScope
import javax.inject.Inject

// A unique instance of LoginViewModel is provided in Components
// annotated with @ActivityScope
@ActivityScope
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    fun getStringName(): String? {
        return userRepository.getStringName()
    }
}