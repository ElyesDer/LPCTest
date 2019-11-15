package com.lakooz.lpctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity() {

    var swipeRefreshLayout: SwipeRefreshLayout? = null
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager2? = null
    var tabAdapter: ViewPagerAdapter? = null


    private val tabLabels: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO : set content view and declare views
        setContentView(R.layout.activity_main)


        // init labels
        tabLabels!!.add(getString(R.string.birthday))
        tabLabels!!.add(getString(R.string.birthday))
        tabLabels!!.add(getString(R.string.birthday))

        // some binding stuff ; no time for butterknife
        // init vi
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.viewPager2)
        swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)

        // setup tablayout content array
        tabLayout!!.addTab(tabLayout!!.newTab().setText(tabLabels[0]))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(tabLabels[1]))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(tabLabels[2]))


        tabAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager!!.adapter = tabAdapter

        setSupportActionBar(toolbar)

        TabLayoutMediator(tabLayout!!, viewPager!!,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                // TODO : set tabs titles
                tab.text = tabLabels[position]
            }).attach()


        swipeRefreshLayout!!.setProgressViewOffset(
            true,
            START_SWIPE_REFRESH,
            resources.getDimension(R.dimen.swipe_refresh_offset).toInt()
        )

        // TODO : set up view model


        swipeRefreshLayout!!.setOnRefreshListener {
            // TODO
        }

        viewPager!!.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                val viewPagerIdle = state == ViewPager2.SCROLL_STATE_IDLE
                swipeRefreshLayout!!.isEnabled = viewPagerIdle
            }
        })

        fab.setOnClickListener {
            // TODO
        }
    }

    companion object {
        private const val START_SWIPE_REFRESH = 50
    }
}
