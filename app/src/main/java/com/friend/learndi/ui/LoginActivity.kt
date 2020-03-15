package com.friend.learndi.ui

/*
* https://developer.android.com/training/dependency-injection/manual
* */
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.friend.learndi.DIApplication
import com.friend.learndi.R

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appContainer = (application as DIApplication).appContainer
        val loginViewModel = appContainer.loginViewModelFactory.create()
        loginViewModel.getName()
        /*
        * But there are still some challenges :
        * 1. You have to manage AppContainer yourself, creating instances for all dependencies by hand.
        * 2. There is still a lot of boilerplate code. You need to crate factories or parameters by hands depending on whether you want to reuse or not
        * */
    }
}
