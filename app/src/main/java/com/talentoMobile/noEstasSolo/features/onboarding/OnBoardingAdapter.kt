package com.talentoMobile.noEstasSolo.features.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.talentoMobile.noEstasSolo.R
import java.util.*

class OnBoardingAdapter(val mContext: Context, val onBoardingItem: ArrayList<OnBoardingItem>) :
    PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`
    override fun getCount(): Int = onBoardingItem.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View =
            LayoutInflater.from(mContext).inflate(R.layout.item_onboarding, container, false)
        val item = onBoardingItem[position]

        val ivBackground = itemView.findViewById<ImageView>(R.id.ivBackground)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDescription =
            itemView.findViewById<TextView>(R.id.tvDescription)

        tvTitle.text = item.title
        tvDescription.text = item.description

        if (item.imageID == 0)
            ivBackground.visibility = View.GONE
        else {
            ivBackground.visibility = View.VISIBLE
            ivBackground.setImageResource(item.imageID)
        }

        container.addView(itemView)
        return itemView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}
