package com.lakooz.lpctest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO : set content view and declare views
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager2)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        val tabLabels: ArrayList<String> = arrayListOf()
        tabLabels.add(getString(R.string.birthday))
        tabLabels.add(getString(R.string.farewell))
        tabLabels.add(getString(R.string.solidarity))

        setSupportActionBar(toolbar)

        TabLayoutMediator(tabLayout, viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                // TODO : set tabs titles
                tab.text = tabLabels[position]
            }).attach()


        swipeRefreshLayout.setProgressViewOffset(
            true,
            START_SWIPE_REFRESH,
            resources.getDimension(R.dimen.swipe_refresh_offset).toInt()
        )

        // TODO : set up view model
        val viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        viewModel.isRefreshing.observeForever {
            swipeRefreshLayout.isRefreshing = it
        }

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.getPots()
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                val viewPagerIdle = state == ViewPager2.SCROLL_STATE_IDLE
                swipeRefreshLayout.isEnabled = viewPagerIdle
            }
        })

        fab.setOnClickListener {
            viewModel.createPot(viewPager.currentItem)
            viewModel.getPots()
        }
    }

    companion object {
        private const val START_SWIPE_REFRESH = 50
    }
}
