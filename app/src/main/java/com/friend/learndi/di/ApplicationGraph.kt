package com.friend.learndi.di

import com.friend.learndi.ui.LoginActivity
import dagger.Component
import javax.inject.Singleton


// Scoping with Dagger
// @ApplicationScope, @LoggedUserScope, and @ActivityScope.
/*
* Dagger components
* Dagger can create a graph of the dependencies in your project  that it can use to find out where it should get those dependencies when they are needed
* @Component tells Dagger to generate a container with all the dependencies required to satisfy the types it exposes
* */
@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationGraph {

    // This tells Dagger that LoginActivity requests injection so the graph needs to
    // satisfy all the dependencies of the fields that LoginActivity is requesting.
    fun inject(activity: LoginActivity)
}
