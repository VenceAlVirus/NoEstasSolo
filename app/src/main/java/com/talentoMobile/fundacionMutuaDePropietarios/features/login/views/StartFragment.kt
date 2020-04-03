package com.talentoMobile.fundacionMutuaDePropietarios.features.login.views

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.davidups.starwars.R
import com.davidups.starwars.core.extensions.onClick
import com.davidups.starwars.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_start

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListerners()
    }

    private fun initListerners() {
        btnStart onClick { this.navigateToLogin() }
    }

    private fun navigateToLogin() {
        view?.findNavController()?.navigate(R.id.action_startFragment_to_loginFragment)
    }
}