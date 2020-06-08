package com.talentoMobile.noEstasSolo.features.news.views

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.davidups.starwars.core.extensions.randomImage
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.Constants
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import com.talentoMobile.noEstasSolo.features.news.adapter.NewsListAdapter
import com.talentoMobile.noEstasSolo.features.news.models.New
import com.thedeanda.lorem.LoremIpsum
import kotlinx.android.synthetic.main.fragment_news.*
import org.jetbrains.anko.bundleOf

class NewsFragments : BaseFragment() {
    override fun layoutId() = R.layout.fragment_news
    private val adapter = NewsListAdapter()
    private val lorem = LoremIpsum.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListeners()
    }

    private fun initView() {
        rvNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvNews.adapter = adapter

        adapter.collection = generateNews()
    }

    private fun generateNews(): MutableList<New> {

        var news = mutableListOf<New>()
        for (n in 0..12) {
            news.add(
                New(
                    lorem.getWords((0..5).random()),
                    String.randomImage(),
                    "9-12-2019, 17:00h",
                    lorem.getWords(1),
                    lorem.getParagraphs(1,3)
                )
            )
        }
        return news
    }

    private fun initListeners() {
        adapter.clickListener = {
            val bundle = bundleOf(Constants.NEW to it)
            view?.findNavController()?.navigate(R.id.action_newsFragment_to_newFragment, bundle)
        }
    }
}