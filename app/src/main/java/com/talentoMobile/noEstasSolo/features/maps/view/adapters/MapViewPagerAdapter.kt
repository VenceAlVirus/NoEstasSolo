package com.talentoMobile.noEstasSolo.features.maps.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.talentoMobile.noEstasSolo.features.maps.view.MapDetailFragment

class MapViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private var fragments: ArrayList<Fragment> = arrayListOf(
        MapDetailFragment()
    )

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MapDetailFragment()
            else -> Fragment()
        }
    }

    override fun getItemCount(): Int {
        return fragments.size
    }
}