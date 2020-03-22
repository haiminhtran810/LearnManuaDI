package com.friend.learndi.data

import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val loginService: LoginRetrofitService) {
    fun getStringName(): String? {
        return "UserRemoteDataSource"
    }
}