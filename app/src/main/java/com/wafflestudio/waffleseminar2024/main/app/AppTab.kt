package com.wafflestudio.waffleseminar2024.main.app

import android.app.Activity
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.wafflestudio.waffleseminar2024.databinding.TabAppBinding
import com.wafflestudio.waffleseminar2024.main.Tab

class AppTab(override val viewModel: ViewModel, activity: Activity) : Tab {

    override val getBinding = { parent: ViewGroup ->
        TabAppBinding.inflate(activity.layoutInflater, parent, false)
    }

    override fun bind() {
    }

}