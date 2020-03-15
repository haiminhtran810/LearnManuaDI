package com.friend.learndi

import com.friend.learndi.data.LoginRetrofitService
import com.friend.learndi.data.UserLocalDataSource
import com.friend.learndi.data.UserRemoteDataSource
import com.friend.learndi.data.UserRepository
import com.friend.learndi.di.LoginViewModelFactory
import retrofit2.Retrofit

class AppContainer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com.vn/")
        .build()
        .create(LoginRetrofitService::class.java)

    private val remoteDataSource = UserRemoteDataSource(retrofit)
    private val localDataSource = UserLocalDataSource()
    private val userRepository = UserRepository(localDataSource, remoteDataSource)
    val loginViewModelFactory = LoginViewModelFactory(userRepository)
}