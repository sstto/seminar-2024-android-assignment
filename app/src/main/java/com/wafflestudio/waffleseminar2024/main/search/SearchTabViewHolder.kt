package com.wafflestudio.waffleseminar2024.main.search

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.wafflestudio.waffleseminar2024.databinding.TabSearchBinding
import com.wafflestudio.waffleseminar2024.main.TabLayoutViewAdapter

class SearchTabViewHolder(val viewModel: SearchViewModel, val activity: AppCompatActivity, parent: ViewGroup) : TabLayoutViewAdapter.TabViewHolder(TabSearchBinding.inflate(activity.layoutInflater, parent, false)) {

    private val binding = super.viewBinding as TabSearchBinding

    override fun bind() {
        val genresBodyRecyclerView = binding.genreListBody.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = GenreViewAdapter()
        }

        viewModel.genres.observe(activity) { genres ->
            (genresBodyRecyclerView.adapter as GenreViewAdapter).updateItems(genres)
        }
    }

}