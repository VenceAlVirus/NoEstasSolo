package com.talentoMobile.noEstasSolo.features.offerAndDemand.views.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davidups.starwars.core.extensions.randomImage
import com.talentoMobile.noEstasSolo.core.extensions.inflate
import com.talentoMobile.noEstasSolo.core.extensions.invisible
import com.talentoMobile.noEstasSolo.core.extensions.visible
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.extensions.loadFromUrlCircle
import com.talentoMobile.noEstasSolo.features.offerAndDemand.models.Product
import kotlinx.android.synthetic.main.item_needed_row.view.*
import kotlin.properties.Delegates

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    internal var collection: List<Product> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (Product) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_needed_row))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener)
    }

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Product, clickListener: (Product) -> Unit) {

            itemView.ivEvent.loadFromUrlCircle(String.randomImage())
            itemView.tvTitle.text = item.title
            if (item.isProfesional) {
                itemView.tvProfesional.visible()
            } else {
                itemView.tvProfesional.invisible()
            }
            itemView.cvProduct.setOnClickListener {
                clickListener(item)
            }
        }

    }
}