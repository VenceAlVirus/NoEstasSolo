package com.talentoMobile.fundacionMutuaDePropietarios.features.signIn.views

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.davidups.starwars.R
import com.davidups.starwars.core.extensions.onClick
import com.davidups.starwars.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_sing_in.*

class SignInFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_sing_in


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        btnEnter onClick this::registryUser
    }

    private fun registryUser() {
        navigateToEnterCode()
    }

    private fun navigateToEnterCode() {
        view?.findNavController()?.navigate(R.id.action_signin_to_email_code_fragment)
    }
}