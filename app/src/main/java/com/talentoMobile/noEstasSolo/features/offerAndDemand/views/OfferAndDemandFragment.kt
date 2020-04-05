package com.talentoMobile.noEstasSolo.features.offerAndDemand.views

import OfferAndDemandViewPagerAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_offer_and_demand.*

class OfferAndDemandFragment:BaseFragment() {
    override fun layoutId() = R.layout.fragment_offer_and_demand

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpagger.adapter = OfferAndDemandViewPagerAdapter(childFragmentManager, lifecycle)
        viewpagger.isUserInputEnabled = false

        initListeners()
    }

    private fun initListeners() {
        TabLayoutMediator(tabs, viewpagger, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = when (position) {
                0 -> "Necesito"
                1 -> "Ofrezco"
                else -> ""
            }
        }).attach()
    }
}