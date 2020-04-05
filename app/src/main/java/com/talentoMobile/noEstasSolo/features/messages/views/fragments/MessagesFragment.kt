package com.talentoMobile.noEstasSolo.features.messages.views.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.davidups.starwars.core.extensions.randomImage
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.loadFromUrlCircle
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_messages.*
import kotlinx.android.synthetic.main.item_message_row.view.*
import kotlinx.android.synthetic.main.item_new_row.view.*

class MessagesFragment : BaseFragment() {
    override fun layoutId(): Int = R.layout.fragment_messages

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item.ivNew.loadFromUrlCircle(String.randomImage())
        item2.ivNew.loadFromUrlCircle(String.randomImage())
        item3.ivNew.loadFromUrlCircle(String.randomImage())

        item.setOnClickListener {
            view.findNavController().navigate(R.id.action_messagesFragment_to_messageChatFragment)
        }

        item2.setOnClickListener {
            view.findNavController().navigate(R.id.action_messagesFragment_to_messageChatFragment)
        }

        item3.setOnClickListener {
            view.findNavController().navigate(R.id.action_messagesFragment_to_messageChatFragment)
        }
    }
}