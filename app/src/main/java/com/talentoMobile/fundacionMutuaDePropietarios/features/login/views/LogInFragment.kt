package com.talentoMobile.fundacionMutuaDePropietarios.features.login.views

import android.animation.LayoutTransition
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import com.davidups.starwars.R
import com.davidups.starwars.core.extensions.onClick
import com.davidups.starwars.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LogInFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListeners()
    }

    private fun initView() {
        clLogin.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }

    private fun initListeners() {

        btnEnter onClick this::login
        btnSignIn onClick this::navigateToSignIn
        tvForgotMyPassword onClick this::navigateToForgotPassword
    }

    private fun login() {
        if (etEmail.text!!.isNotEmpty() && etPassword.text!!.isNotEmpty()){
            Log.w("gola","hola")
        }
    }

    private fun navigateToSignIn() {
        view?.findNavController()?.navigate(R.id.action_loginFragment_to_signIn)
    }

    private fun navigateToForgotPassword() {
        view?.findNavController()?.navigate(R.id.action_loginFragment_to_forgot_my_password)
    }
}