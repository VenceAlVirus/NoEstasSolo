package com.talentoMobile.noEstasSolo.features.onboarding

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager.widget.ViewPager
import com.talentoMobile.noEstasSolo.R
import com.talentoMobile.noEstasSolo.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_onboarding.*
import java.util.*


class OnBoardingFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_onboarding

    private var dotsCount = 0
    private lateinit var dots: Array<ImageView?>

    private lateinit var onboardAdapter: OnBoardingAdapter

    var previous_pos = 0

    var onBoardItems: ArrayList<OnBoardingItem> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        setUpAdapter()

        btnStart.setOnClickListener {
            navigateToStart()
        }

        setUiPageViewController()
    }


    private fun navigateToStart() {
        val navBuilder = NavOptions.Builder()
        val navOptions = navBuilder.setPopUpTo(R.id.main_navigation, true).build()
        NavHostFragment.findNavController(this@OnBoardingFragment)
            .navigate(R.id.newsFragment, null, navOptions)
    }

    //TO ViewModel
    private fun loadData() {
        val titleArr =
            intArrayOf(
                R.string.onboarding_title1, R.string.onboarding_title2, R.string.onboarding_title3,
                R.string.onboarding_title4, R.string.onboarding_title5
            )
        val descArr =
            intArrayOf(
                R.string.onboarding_desc1, R.string.onboarding_desc2, R.string.onboarding_desc3,
                R.string.onboarding_desc4, R.string.onboarding_desc5
            )

        for (i in titleArr.indices) {
            val item =
                OnBoardingItem(resources.getString(titleArr[i]), resources.getString(descArr[i]))
            onBoardItems.add(item)
        }
    }

    private fun setUpAdapter() {
        onboardAdapter = OnBoardingAdapter(context!!, onBoardItems)
        vpPage.adapter = onboardAdapter
        vpPage.currentItem = 0

        vpPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                changeCurrentPosition(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
        })
    }

    private fun changeCurrentPosition(positionPageSelected: Int) {
        for (i in 0 until dotsCount) {
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    context!!,
                    R.drawable.non_selected_item_dot
                )
            )
        }
        dots[positionPageSelected]!!.setImageDrawable(
            ContextCompat.getDrawable(context!!, R.drawable.selected_item_dot)
        )
        previous_pos = positionPageSelected + 1
    }

    private fun setUiPageViewController() {
        dotsCount = onboardAdapter.getCount()
        dots = arrayOfNulls(dotsCount)
        for (i in 0 until dotsCount) {
            dots[i] = ImageView(context)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    context!!,
                    R.drawable.non_selected_item_dot
                )
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(6, 0, 6, 0)
            llCountDots.addView(dots[i], params)
        }
        dots[0]!!.setImageDrawable(
            ContextCompat.getDrawable(
                context!!,
                R.drawable.selected_item_dot
            )
        )
    }

}

