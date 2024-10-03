package com.wafflestudio.waffleseminar2024.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.wafflestudio.waffleseminar2024.R
import com.wafflestudio.waffleseminar2024.databinding.ActivityTabLayoutBinding
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
            Tab.GameTab(this),
            Tab.AppTab(this),
            Tab.SearchTab(searchViewModel, this),
            Tab.ProfileTab(this),
        )

        viewPager = binding.viewPager
        viewPager.adapter = TabLayoutViewAdapter(tabs)
        tabLayout = binding.tabs

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = position.toString()
        }.attach()
    }

}