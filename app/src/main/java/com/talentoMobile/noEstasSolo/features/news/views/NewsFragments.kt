package com.talentoMobile.noEstasSolo.features.news.views

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragments : BaseFragment() {
    override fun layoutId() = R.layout.fragment_news

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item.setOnClickListener {
            view.findNavController().navigate(R.id.action_newsFragment_to_newFragment)
        }
    }

}