package com.friend.learndi.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.friend.learndi.R
import com.friend.learndi.ui.LoginActivity
import com.friend.learndi.ui.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login_username.*
import javax.inject.Inject

class LoginUsernameFragment : Fragment() {
    // Fields that need to be injected by the login graph
    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as LoginActivity).loginComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_username, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textMessageUsername.text =  "LoginUsernameFragment : ${loginViewModel.getStringName()}"
    }

    companion object{
        fun newInstance() = LoginUsernameFragment()
    }
}
