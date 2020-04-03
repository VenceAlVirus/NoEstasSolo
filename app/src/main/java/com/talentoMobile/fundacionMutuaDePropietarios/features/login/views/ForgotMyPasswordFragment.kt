package com.talentoMobile.fundacionMutuaDePropietarios.features.login.views

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.davidups.starwars.R
import com.davidups.starwars.core.extensions.invisible
import com.davidups.starwars.core.extensions.onClick
import com.davidups.starwars.core.extensions.visible
import com.davidups.starwars.core.navigation.MainActivity
import com.davidups.starwars.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_forgot_my_password.*
import kotlinx.android.synthetic.main.insert_code_layout.*

class ForgotMyPasswordFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_forgot_my_password


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListeners()
    }

    private fun initView() {
        clForgotPasswordBanner.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
    }

    private fun initListeners() {
        btnSendMail onClick this::sendEmail
        btnContinue onClick this::sendCode
        btnSavePassword onClick this::updatePassword
    }

    private fun sendEmail() {
        loadCodeScreen()
    }

    private fun loadCodeScreen() {
        (activity as MainActivity).supportActionBar!!.title = getString(R.string.have_an_email)
        ivBanner.setImageResource(R.drawable.ic_banner_forgot_my_password_email)
        tvBanner.text = getString(R.string.forgot_my_password_fragment_banner_two)
        clSendMail.invisible()
        icludeSendCode.visible()
    }

    private fun sendCode() {
        loadUploadPassword()
    }

    private fun loadUploadPassword() {
        (activity as MainActivity).supportActionBar!!.title = getString(R.string.choose_new_password)
        ivBanner.setImageResource(R.drawable.ic_banner_forgot_my_password_key)
        tvBanner.text = getString(R.string.forgot_my_password_fragment_banner_three)
        icludeSendCode.invisible()
        clUpdatePassword.visible()
    }

    private fun updatePassword() {
        view?.findNavController()?.navigate(R.id.action_forgot_my_password_to_login_fragment)
    }
}