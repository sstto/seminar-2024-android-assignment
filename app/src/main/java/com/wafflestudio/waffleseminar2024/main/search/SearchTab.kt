package com.wafflestudio.waffleseminar2024.main.search

import android.app.Activity
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.wafflestudio.waffleseminar2024.databinding.TabSearchBinding
import com.wafflestudio.waffleseminar2024.main.Tab

class SearchTab(override val viewModel: ViewModel, activity: Activity) : Tab {

    override val getBinding = { parent: ViewGroup -> TabSearchBinding.inflate(activity.layoutInflater, parent, false) }

    override fun bind() {
    }

}
