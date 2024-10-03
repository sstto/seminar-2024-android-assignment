package com.wafflestudio.waffleseminar2024.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.wafflestudio.waffleseminar2024.main.search.SearchViewModel

sealed interface Tab {

    val activity: Activity

    class GameTab(override val activity: Activity): Tab

    class AppTab(override val activity: Activity): Tab

    class SearchTab(val viewModel: SearchViewModel, override val activity: Activity): Tab

    class ProfileTab(override val activity: AppCompatActivity): Tab

}