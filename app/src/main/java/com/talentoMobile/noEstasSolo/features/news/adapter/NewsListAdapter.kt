package com.talentoMobile.noEstasSolo.features.news.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.talentoMobile.noEstasSolo.core.extensions.inflate
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.loadFromUrl
import com.talentoMobile.noEstasSolo.features.news.models.New
import kotlinx.android.synthetic.main.item_new_row.view.*
import kotlin.properties.Delegates

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    internal var collection: List<New> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (New) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_new_row))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener, position == collection.size - 1)
    }

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(new: New, clickListener: (New) -> Unit, isFooter: Boolean) {

            itemView.tvTitle.text = new.title
            itemView.tvDate.text = new.date
            itemView.tvPromotor.text = new.source
            itemView.ivEvent.loadFromUrl(new.image)
            itemView.cvNew.setOnClickListener {
                clickListener(new)
            }
        }

    }
}