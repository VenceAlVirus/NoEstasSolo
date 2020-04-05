package com.talentoMobile.noEstasSolo.features.perfil.views

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvEditar.setOnClickListener {
            navigateToEditProfile()
        }
    }


    private fun navigateToEditProfile() {
        findNavController().navigate(R.id.editProfileFragment)
    }
}

