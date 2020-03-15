package com.friend.learndi.ui

/*
* https://developer.android.com/training/dependency-injection/manual
* */
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.friend.learndi.AppContainer
import com.friend.learndi.DIApplication
import com.friend.learndi.R
import com.friend.learndi.data.LoginUserData

class LoginActivity : AppCompatActivity() {
    private var loginViewModel: LoginViewModel? = null
    private var appContainer: AppContainer? = null
    private var loginData: LoginUserData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appContainer = (application as DIApplication).appContainer
        appContainer?.let {
            it.loginContainer = LoginContainer(it.userRepository)
            val loginViewModel = it.loginContainer?.loginViewModelFactory?.create()
            loginData = appContainer?.loginContainer?.loginData
        }
    }

    override fun onDestroy() {
        // if container do not need to use. I might remember to delete
        if (loginData != null) {
            appContainer?.loginContainer = null
        }
        super.onDestroy()
    }
}
