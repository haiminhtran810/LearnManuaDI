package com.friend.learndi.data

import javax.inject.Inject
import javax.inject.Singleton

/*
* @Inject lets Dagger know how to create instances of this object
* */
@Singleton
class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) {
    fun getStringName(): String? {
        return "${localDataSource.getStringName()} - ${remoteDataSource.getStringName()}"
    }
}