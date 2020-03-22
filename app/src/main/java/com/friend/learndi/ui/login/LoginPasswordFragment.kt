package com.friend.learndi.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.friend.learndi.R
import com.friend.learndi.ui.LoginActivity
import com.friend.learndi.ui.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login_password.*
import javax.inject.Inject

class LoginPasswordFragment : Fragment() {
    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Obtaining the login graph from LoginActivity and instantiate
        // the @Inject fields with objects from the graph
        (activity as LoginActivity).loginComponent.inject(this)

        // Now you can access loginViewModel here and onCreateView too
        // (shared instance with the Activity and the other Fragment)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textMessagePassword.text = "LoginPasswordFragment : ${loginViewModel.getStringName()}"
    }

    companion object {
        fun newInstance() = LoginPasswordFragment()
    }
}
