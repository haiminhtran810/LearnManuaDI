package com.friend.learndi.data

import android.util.Log

class UserRemoteDataSource(loginRetrofitService: LoginRetrofitService){
    fun getName(){
        Log.d("DI-Sample", "UserRemoteDataSource")
    }
}