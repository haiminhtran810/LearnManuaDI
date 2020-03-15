package com.friend.learndi.ui

/*
* https://developer.android.com/training/dependency-injection/manual
* */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.friend.learndi.R
import com.friend.learndi.data.LoginRetrofitService
import com.friend.learndi.data.UserLocalDataSource
import com.friend.learndi.data.UserRemoteDataSource
import com.friend.learndi.data.UserRepository
import retrofit2.Retrofit

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com.vn/")
            .build()
            .create(LoginRetrofitService::class.java)

        val remoteDataSource = UserRemoteDataSource(retrofit)
        val localDataSource = UserLocalDataSource()
        val userRepository = UserRepository(localDataSource, remoteDataSource)
        val loginViewModel = LoginViewModel(userRepository)
        // But it has 3 issue for you :
        /*
        * There's a lot of boilerplate code. If you wanted to create another instance of LoginViewModel in another part of the code, you'd have code duplication.

          Dependencies have to be declared in order. You have to instantiate UserRepository before LoginViewModel in order to create it.

          It's difficult to reuse objects. If you wanted to reuse UserRepository across multiple features, you'd have to make it follow the singleton pattern. The singleton pattern makes testing more difficult because all tests share the same singleton instance.
        * */
    }
}
