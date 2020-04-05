package com.talentoMobile.noEstasSolo.features.perfil.views

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_edit_profile.*

class EditProfileFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_edit_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvSave.setOnClickListener {
            activity!!.onBackPressed()
        }

        tvCancel.setOnClickListener {
            activity!!.onBackPressed()
        }

        btnStart.setOnClickListener { navigateToEditProfile() }

    }

    private fun navigateToEditProfile() {
        findNavController().navigate(R.id.certifyProfileFragment)
    }


}