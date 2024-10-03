package com.wafflestudio.waffleseminar2024.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewAdapter(private val tabs: List<Tab>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TabViewHolder(tabs[viewType], parent)
    }

    override fun getItemCount(): Int = tabs.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TabViewHolder -> holder.bind()
        }
    }

    class TabViewHolder(private val tab: Tab, parent: ViewGroup): RecyclerView.ViewHolder(tab.getBinding(parent).root), Tab by tab

}