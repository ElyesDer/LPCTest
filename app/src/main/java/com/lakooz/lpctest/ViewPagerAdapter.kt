package com.lakooz.lpctest

import android.os.Bundle
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
        val bundle = Bundle()
        bundle.putInt("pos", position)
        val frag = PotsFragment()
        frag.arguments = bundle
        return frag
    }

    override fun getItemCount() = 3
}