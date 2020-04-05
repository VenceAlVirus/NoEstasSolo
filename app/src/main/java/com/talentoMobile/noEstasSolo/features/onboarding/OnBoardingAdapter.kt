package com.talentoMobile.noEstasSolo.features.onboarding

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.talentoMobile.noEstasSolo.R
import java.util.*

class OnBoardingAdapter(
    val mContext: Context,
    val onBoardingItem: ArrayList<OnBoardingItem>,
    val isImage: Boolean
) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`
    override fun getCount(): Int = onBoardingItem.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val item = onBoardingItem[position]


        var itemView: View
        if (isImage) {
            itemView =
                LayoutInflater.from(mContext)
                    .inflate(R.layout.item_onboarding_image, container, false)
            itemView = loadImageItem(item, itemView)

        } else {
            itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_onboarding_text, container, false)
            itemView = loadText(item, itemView)
        }

        container.addView(itemView)
        return itemView
    }

    fun loadImageItem(item: OnBoardingItem, itemView: View): View {
        val ivBackground = itemView.findViewById<ImageView>(R.id.ivBackground)
        if (item.imageID == 0)
            ivBackground.visibility = View.INVISIBLE
        else {
            ivBackground.visibility = View.VISIBLE
            ivBackground.setImageResource(item.imageID)
        }
        return itemView
    }

    fun loadText(item: OnBoardingItem, itemView: View): View {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription =
            itemView.findViewById<TextView>(R.id.tvDescription)

        tvTitle.text = Html.fromHtml( item.title )
        tvDescription.text = item.description
        return itemView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}
