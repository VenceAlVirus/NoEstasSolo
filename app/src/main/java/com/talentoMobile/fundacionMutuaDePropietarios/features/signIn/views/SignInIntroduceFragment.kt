package com.talentoMobile.fundacionMutuaDePropietarios.features.signIn.views

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.davidups.starwars.R
import com.davidups.starwars.core.extensions.onClick
import com.davidups.starwars.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_introduce_signin.*

class SignInIntroduceFragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_introduce_signin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        btnSave onClick this::saveUser
    }

    private fun saveUser() {
        navigateToKeepInTouch()
    }

    private fun navigateToKeepInTouch() {

        view?.findNavController()?.navigate(R.id.action_presentation_fragment_to_add_contact_fragment)
    }
}