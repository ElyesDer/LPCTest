package com.lakooz.lpctest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//TODO : Set up the three tabs
class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    // may use a list ?
    private val fragments = ArrayList<Fragment>()

    override fun createFragment(position: Int): Fragment {
        // based on position or maybe only one frag to use
        return PotsFragment()
    }


    override fun getItemCount() = fragments.count()
}