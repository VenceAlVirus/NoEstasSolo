package com.talentoMobile.noEstasSolo.features.offerAndDemand.views

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.davidups.starwars.core.extensions.randomImage
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.Constants
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import com.talentoMobile.noEstasSolo.features.offerAndDemand.models.FilterItem
import com.talentoMobile.noEstasSolo.features.offerAndDemand.models.Product
import com.talentoMobile.noEstasSolo.features.offerAndDemand.views.adapters.FilterItemsAdapter
import com.talentoMobile.noEstasSolo.features.offerAndDemand.views.adapters.ProductListAdapter
import com.thedeanda.lorem.LoremIpsum
import kotlinx.android.synthetic.main.fragment_offer.*
import org.jetbrains.anko.bundleOf
import kotlin.random.Random

class OfferFragment: BaseFragment() {
    override fun layoutId() = R.layout.fragment_offer
    private val filterAdapter = FilterItemsAdapter()
    private val offerAdapter = ProductListAdapter()
    private val lorem = LoremIpsum.getInstance()
    private var filterList = mutableListOf(
        FilterItem("Todo", String.randomImage()),
        FilterItem("Educación", String.randomImage()),
        FilterItem("Asistencia", String.randomImage()),
        FilterItem("Recados", String.randomImage()),
        FilterItem("Otros", String.randomImage())
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFilterList()
        initNeededList()
    }

    private fun initFilterList() {
        rvFilters.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvFilters.adapter = filterAdapter

        filterAdapter.collection = filterList
    }

    private fun initNeededList() {

        rvOffer.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvOffer.adapter = offerAdapter

        var offerList = mutableListOf<Product>()
        for (n in 0..15) {
            offerList.add(
                Product(
                    lorem.getWords((4..9).random()),
                    "Madrid, Madrid",
                    Random.nextBoolean(),
                    filterList[(0..4).random()].filterName,
                    lorem.getParagraphs(1, 3)
                )
            )
        }

        offerAdapter.collection = offerList

        offerAdapter.clickListener = {
            val bundle = bundleOf(Constants.PRODUCT to it)
            view?.findNavController()
                ?.navigate(R.id.action_offerAndDemandFragment_to_ProductDetail, bundle)
        }
    }
}