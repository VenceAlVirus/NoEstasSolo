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
import kotlinx.android.synthetic.main.fragment_needed.*
import org.jetbrains.anko.bundleOf
import kotlin.random.Random

class NeededFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_needed

    private val filterAdapter = FilterItemsAdapter()
    private val neededAdapter = ProductListAdapter()
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

        rvNeeded.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvNeeded.adapter = neededAdapter

        var neededList = mutableListOf<Product>()
        for (n in 0..15) {
            neededList.add(
                Product(
                    lorem.getWords((4..9).random()),
                    "Madrid, Madrid",
                    Random.nextBoolean(),
                    filterList[(0..4).random()].filterName,
                    lorem.getParagraphs(1, 2)
                )
            )
        }

        neededAdapter.collection = neededList

        neededAdapter.clickListener = {
            val bundle = bundleOf(Constants.PRODUCT to it)
            view?.findNavController()
                ?.navigate(R.id.action_offerAndDemandFragment_to_ProductDetail, bundle)
        }
    }
}