package com.talentoMobile.fundacionMutuaDePropietarios.features.signIn.views

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.davidups.starwars.R
import com.davidups.starwars.core.extensions.onClick
import com.davidups.starwars.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_add_contact_signin.*

class SignInAddContactFragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_add_contact_signin

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {

        btnSave onClick this::saveContactData
        btnSkip onClick this::navigateToWellcome
    }

    private fun saveContactData() {
        navigateToWellcome()
    }

    private fun navigateToWellcome() {
        view?.findNavController()?.navigate(R.id.action_contact_fragment_to_wellcome_fragment)
    }
}