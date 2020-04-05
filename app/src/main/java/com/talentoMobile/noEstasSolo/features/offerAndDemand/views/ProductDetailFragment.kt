package com.talentoMobile.noEstasSolo.features.offerAndDemand.views

import android.os.Bundle
import android.view.View
import com.talentoMobile.noEstasSolo.core.extensions.loadFromUrlCircle
import com.davidups.starwars.core.extensions.randomImage
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.Constants
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import com.talentoMobile.noEstasSolo.features.maps.view.adapters.MapViewPagerAdapter
import com.talentoMobile.noEstasSolo.features.offerAndDemand.models.Product
import com.thedeanda.lorem.LoremIpsum
import kotlinx.android.synthetic.main.fragment_product_detail_fragment.*

class ProductDetailFragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_product_detail_fragment

    private lateinit var product: Product
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = arguments
        if (arguments != null) {
            product = arguments.getSerializable(Constants.PRODUCT) as Product
            initView()
        }
    }

    private fun initView() {
        ivUser.loadFromUrlCircle(String.randomImage())
        tvUserName.text = LoremIpsum.getInstance().getWords(2)
        ivProductType.loadFromUrlCircle(String.randomImage())
        tvProductType.text = product.productType
        tvTitle.text = product.title
        tvInfo.text = product.description
        vpMap.adapter =
            MapViewPagerAdapter(
                childFragmentManager,
                lifecycle
            )
        vpMap.isUserInputEnabled = false
    }
}