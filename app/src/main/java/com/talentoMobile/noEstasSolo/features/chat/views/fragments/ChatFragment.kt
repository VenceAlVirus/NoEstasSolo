package com.talentoMobile.noEstasSolo.features.chat.views.fragments

import android.os.Bundle
import android.view.View
import com.davidups.starwars.core.extensions.randomImage
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.loadFromUrlCircle
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.item_message_row.view.*

class ChatFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_chat

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item.ivNew.loadFromUrlCircle(String.randomImage())
        item.ivChevron.visibility = View.GONE


    }

}