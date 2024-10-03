package com.wafflestudio.waffleseminar2024.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.wafflestudio.waffleseminar2024.main.app.AppTabViewHolder
import com.wafflestudio.waffleseminar2024.main.game.GameTabViewHolder
import com.wafflestudio.waffleseminar2024.main.profile.ProfileTabViewHolder
import com.wafflestudio.waffleseminar2024.main.search.SearchTabViewHolder

class TabLayoutViewAdapter(private val tabs: List<Tab>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(val tab = tabs[viewType]) {
            is Tab.GameTab -> GameTabViewHolder(tab.activity, parent)
            is Tab.AppTab -> AppTabViewHolder(tab.activity, parent)
            is Tab.SearchTab -> SearchTabViewHolder(tab.viewModel, tab.activity, parent)
            is Tab.ProfileTab -> ProfileTabViewHolder(tab.activity, parent)
        }
    }

    override fun getItemCount(): Int = tabs.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TabViewHolder -> holder.bind()
        }
    }

    abstract class TabViewHolder(val viewBinding: ViewBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        abstract fun bind()
    }

}