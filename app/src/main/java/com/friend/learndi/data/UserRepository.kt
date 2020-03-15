package com.friend.learndi.data

import android.util.Log

class UserRepository(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) {
    fun getName() {
        Log.d("DI-Sample", "${localDataSource.getName()} - ${remoteDataSource.getName()} ")
    }
}