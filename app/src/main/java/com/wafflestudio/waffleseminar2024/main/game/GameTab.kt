package com.wafflestudio.waffleseminar2024.main.game

import android.app.Activity
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.wafflestudio.waffleseminar2024.databinding.TabGameBinding
import com.wafflestudio.waffleseminar2024.main.Tab

class GameTab(override val viewModel: ViewModel, activity: Activity) : Tab {

    override val getBinding = { parent: ViewGroup -> TabGameBinding.inflate(activity.layoutInflater, parent, false) }

    override fun bind() {
    }

}