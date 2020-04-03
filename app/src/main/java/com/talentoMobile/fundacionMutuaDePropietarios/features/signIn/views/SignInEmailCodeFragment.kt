package com.talentoMobile.fundacionMutuaDePropietarios.features.signIn.views

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.davidups.starwars.R
import com.davidups.starwars.core.extensions.onClick
import com.davidups.starwars.core.platform.BaseFragment
import kotlinx.android.synthetic.main.insert_code_layout.*

class SignInEmailCodeFragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_email_code_signin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListerners()
    }

    private fun initListerners() {

        btnContinue onClick this::sendCode
    }

    private fun sendCode() {

        navigateToPresentation()
    }

    private fun navigateToPresentation() {

        view?.findNavController()?.navigate(R.id.action_email_code_fragment_to_presentation_fragment)
    }
}