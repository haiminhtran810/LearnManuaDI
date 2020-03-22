package com.friend.learndi.data

import javax.inject.Inject

class UserLocalDataSource @Inject constructor(){
    fun getStringName():String?{
        return "UserLocalDataSource"
    }
}