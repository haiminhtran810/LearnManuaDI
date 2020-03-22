package com.friend.learndi.ui

/*
* https://developer.android.com/training/dependency-injection/manual
* */
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.friend.learndi.DIApplication
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    // You want Dagger to provide an instance of LoginViewModel from the graph
    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Make Dagger instantiate @Inject fields in LoginActivity
        (applicationContext as DIApplication).applicationGraph.inject(this)
        // Now loginViewModel is available
        super.onCreate(savedInstanceState)
        val name = loginViewModel.getStringName()
        Log.d("LoginActivity", name)
    }
}
