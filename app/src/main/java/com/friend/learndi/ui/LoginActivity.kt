package com.friend.learndi.ui

/*
* https://developer.android.com/training/dependency-injection/manual
* */
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.friend.learndi.DIApplication
import com.friend.learndi.R
import com.friend.learndi.di.LoginComponent
import com.friend.learndi.ui.login.LoginPasswordFragment
import com.friend.learndi.ui.login.LoginUsernameFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    // You want Dagger to provide an instance of LoginViewModel from the graph
    @Inject
    lateinit var loginViewModel: LoginViewModel
    // Reference to the Login graph
    lateinit var loginComponent: LoginComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        loginComponent =
            (applicationContext as DIApplication).appComponent.loginComponent().create()
        // Make Dagger instantiate @Inject fields in LoginActivity
        loginComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = loginViewModel.getStringName()
        textViewMessage.text = "LoginActivity : $name"
        Log.d("LoginActivity", name)
        showFragment()
    }

    private fun showFragment() {
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(R.id.container1, LoginUsernameFragment.newInstance())
        fragmentManager.replace(R.id.container2, LoginPasswordFragment.newInstance())
        fragmentManager.commit()
    }
}
