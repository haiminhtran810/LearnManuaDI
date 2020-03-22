package com.friend.learndi.di

import com.friend.learndi.ui.LoginActivity
import com.friend.learndi.ui.login.LoginPasswordFragment
import com.friend.learndi.ui.login.LoginUsernameFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(activity: LoginActivity)
    fun inject(fragment: LoginUsernameFragment)
    fun inject(fragment: LoginPasswordFragment)
}