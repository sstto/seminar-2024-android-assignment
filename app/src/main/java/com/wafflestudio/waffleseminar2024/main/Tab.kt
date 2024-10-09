package com.wafflestudio.waffleseminar2024.main

import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import com.wafflestudio.waffleseminar2024.main.search.SearchViewModel

sealed interface Tab {

    val activity: Activity

    val name: String

    val icon: Drawable?

    class GameTab(override val activity: Activity, override val name: String, override val icon: Drawable?): Tab

    class AppTab(override val activity: Activity, override val name: String, override val icon: Drawable?): Tab

    class SearchTab(val viewModel: SearchViewModel, override val activity: AppCompatActivity, override val name: String, override val icon: Drawable?): Tab

    class ProfileTab(override val activity: AppCompatActivity, override val name: String, override val icon: Drawable?): Tab

}