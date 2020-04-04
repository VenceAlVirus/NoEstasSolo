package com.talentoMobile.noEstasSolo.features.offerAndDemand.views.adapters

import android.content.SharedPreferences
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davidups.starwars.core.extensions.inflate
import com.davidups.starwars.core.extensions.loadFromUrlCircle
import com.davidups.starwars.core.extensions.randomImage
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.features.offerAndDemand.models.FilterItem
import kotlinx.android.synthetic.main.item_filter_row.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.properties.Delegates

class FilterItemsAdapter : RecyclerView.Adapter<FilterItemsAdapter.ViewHolder>() {

    internal var collection: List<FilterItem> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (FilterItem) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_filter_row))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener)
    }

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: FilterItem, clickListener: (FilterItem) -> Unit) {
            itemView.ivFilter.loadFromUrlCircle(item.filterPicture)
            itemView.tvFilerName.text = item.filterName
        }

    }
}