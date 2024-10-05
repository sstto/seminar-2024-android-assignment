package com.wafflestudio.waffleseminar2024.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.wafflestudio.waffleseminar2024.R
import com.wafflestudio.waffleseminar2024.databinding.ActivityTabLayoutBinding
import com.wafflestudio.waffleseminar2024.databinding.TabIconBinding
import com.wafflestudio.waffleseminar2024.main.search.SearchViewModel

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    private lateinit var tabLayout: TabLayout

    private lateinit var binding: ActivityTabLayoutBinding

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tabs = listOf(
            Tab.GameTab(this, "게임", AppCompatResources.getDrawable(this, R.drawable.ic_tab_game)),
            Tab.AppTab(this, "앱", AppCompatResources.getDrawable(this, R.drawable.ic_tab_app)),
            Tab.SearchTab(searchViewModel, this, "검색", AppCompatResources.getDrawable(this, R.drawable.ic_tab_search)),
            Tab.ProfileTab(this, "프로필", AppCompatResources.getDrawable(this, R.drawable.ic_tab_profile)),
        )

        viewPager = binding.viewPager.apply { adapter = TabLayoutViewAdapter(tabs) }
        tabLayout = binding.tabs.apply {
//            addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
//                override fun onTabSelected(tab: TabLayout.Tab) {
//                   tab.customView?.apply {
//                        findViewById<ImageView>(R.id.tab_icon).apply {
//                            setTabIconTintResource(R.color.tab_color_selector)
//                            setColorFilter(R.color.tab_color_selector)
//                            setBackgroundResource(R.color.tab_background_color_selector)
//                        }
//                    }
//                }
//
//                override fun onTabUnselected(tab: TabLayout.Tab?) {
//                }
//
//                override fun onTabReselected(tab: TabLayout.Tab?) {
//                }
//
//            })
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabView = TabIconBinding.inflate(layoutInflater).apply {
                tabIcon.setImageDrawable(tabs[position].icon)
                tabText.text = tabs[position].name
            }.root

            tab.customView = tabView
        }.attach()
    }

}