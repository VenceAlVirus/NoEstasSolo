package com.talentoMobile.noEstasSolo.features.messages.views.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*

class MessagesFragment : BaseFragment() {
    override fun layoutId(): Int = R.layout.fragment_messages

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item.setOnClickListener {
            //view.findNavController().navigate(R.id.action_messagesFragment_to_messageChatFragment) ¿?
        }
    }
}