package com.talentoMobile.noEstasSolo.features.maps.view

import android.os.Bundle
import android.view.View
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import com.talentoMobile.noEstasSolo.features.maps.view.adapters.MapViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_product_detail_fragment.*

class MapFragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_map

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vpMap.adapter =
            MapViewPagerAdapter(
                childFragmentManager,
                lifecycle
            )
        vpMap.isUserInputEnabled = false
    }
}