package com.talentoMobile.noEstasSolo.features.news.views

import android.os.Bundle
import android.view.View
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.Constants
import com.talentoMobile.noEstasSolo.core.extensions.loadFromUrl
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import com.talentoMobile.noEstasSolo.features.news.models.New
import kotlinx.android.synthetic.main.fragment_new_detail.*

class NewDetailFragment: BaseFragment() {

    override fun layoutId() = R.layout.fragment_new_detail
    private lateinit var new: New

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = arguments
        if (arguments != null) {
            new = arguments.getSerializable(Constants.NEW) as New
            initView()
        }
    }

    private fun initView() {
        ivNewDetail.loadFromUrl(new.image)
        tvSource.text = new.source
        tvInformation.text = new.detail
        tvDate.text = new.date
    }
}