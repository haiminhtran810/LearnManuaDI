package com.friend.learndi.di

import com.friend.learndi.data.LoginRetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

// @Module informs Dagger that this class is a Dagger Module
// Modules are a way to semantically encapsulate information on how to provide objects
@Module
class NetworkModule {
    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. LoginRetrofitService).
    // Function parameters are the dependencies of this type.
    @Singleton
    @Provides
    fun provideLoginRetrofitService(): LoginRetrofitService = Retrofit.Builder()
        .baseUrl("https://www.google.com.vn/")
        .build()
        .create(LoginRetrofitService::class.java)

}