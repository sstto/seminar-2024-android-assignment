package com.wafflestudio.waffleseminar2024.main

import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

interface Tab {

    val viewModel: ViewModel

    val getBinding: (ViewGroup) -> ViewBinding

    fun bind()

}