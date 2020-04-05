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

    private lateinit var onboardAdapterText: OnBoardingAdapter
    private lateinit var onboardAdapterImage: OnBoardingAdapter

    var previous_pos = 0
    var actual_pos = 0

    var onBoardItems: ArrayList<OnBoardingItem> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        setUpAdapter()

        tvSkip.setOnClickListener {
            navigateToStart()
        }

        setUiPageViewController()
    }


    private fun navigateToStart() {
        val navBuilder = NavOptions.Builder()
        val navOptions = navBuilder.setPopUpTo(R.id.main_navigation, true).build()
        NavHostFragment.findNavController(this@OnBoardingFragment)
            .navigate(R.id.offerAndDemandFragment, null, navOptions)
    }

    private fun navigateToNext() {
        vpImages.currentItem = actual_pos + 1
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

        val imgArr =
            intArrayOf(
                R.drawable.onboarding_1, R.drawable.onboarding_2, R.drawable.onboarding_3,
                R.drawable.onboarding_4, R.drawable.onboarding_5
            )

        for (i in titleArr.indices) {
            val item =
                OnBoardingItem(
                    resources.getString(titleArr[i]),
                    resources.getString(descArr[i]),
                    imgArr[i]
                )
            onBoardItems.add(item)
        }
    }

    private fun setUpAdapter() {

        firstPosition()

        onboardAdapterText = OnBoardingAdapter(context!!, onBoardItems, false)
        onboardAdapterImage = OnBoardingAdapter(context!!, onBoardItems, true)

        vpText.adapter = onboardAdapterText
        vpText.currentItem = 0

        vpImages.adapter = onboardAdapterImage
        vpImages.currentItem = 0

        vpImages.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                actual_pos = position
                changeCurrentPosition(position)
                vpText.currentItem = position
            }

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
        })

        vpText.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                actual_pos = position
                changeCurrentPosition(position)
                vpImages.currentItem = position
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
        if (positionPageSelected == onBoardItems.size - 1)
            lastPosition()
        else if (positionPageSelected == 0)
            firstPosition()
        else tvSkip.visibility = View.VISIBLE


    }

    private fun firstPosition() {
        tvSkip.visibility = View.INVISIBLE
        btnStart.setText(getText(R.string.onboarding_button_next))
        btnStart.setOnClickListener {
            navigateToNext()
        }

    }

    private fun lastPosition() {
        tvSkip.visibility = View.GONE
        btnStart.setText(getText(R.string.onboarding_button_start))
        btnStart.setOnClickListener {
            navigateToStart()
        }
    }

    private fun setUiPageViewController() {
        dotsCount = onboardAdapterText.getCount()
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
            llDots.addView(dots[i], params)
        }
        dots[0]!!.setImageDrawable(
            ContextCompat.getDrawable(
                context!!,
                R.drawable.selected_item_dot
            )
        )
    }

}

