package com.friend.learndi

import com.friend.learndi.data.LoginRetrofitService
import com.friend.learndi.data.UserLocalDataSource
import com.friend.learndi.data.UserRemoteDataSource
import com.friend.learndi.data.UserRepository
import com.friend.learndi.di.LoginViewModelFactory
import com.friend.learndi.ui.LoginContainer
import retrofit2.Retrofit

class AppContainer {
    /*
    * AppContainer gets complicated when you want to include more functionality in the project. When your app become larger
    * and you start introducing different features flows. There are even more problem that raise:
    * 1. When you have different flows, you might want object to live in scope of that flow.
    * 2. Optimizing the application graph and flow  can also be difficult. Important, you need to remember to delete instance that you do not need
    * */

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com.vn/")
        .build()
        .create(LoginRetrofitService::class.java)

    private val remoteDataSource = UserRemoteDataSource(retrofit)
    private val localDataSource = UserLocalDataSource()
    val userRepository = UserRepository(localDataSource, remoteDataSource)
    var loginContainer: LoginContainer? = null
}