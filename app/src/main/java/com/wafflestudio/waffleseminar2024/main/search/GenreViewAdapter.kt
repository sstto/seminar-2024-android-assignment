package com.wafflestudio.waffleseminar2024.main.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.waffleseminar2024.R
import com.wafflestudio.waffleseminar2024.main.search.data.Genre

class GenreViewAdapter(private var items: List<Genre> = mutableListOf()) : RecyclerView.Adapter<GenreViewAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_item_layout, parent, false)
        return GenreViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class GenreViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(pos: Int) {
            val textView = itemView.findViewById<TextView>(R.id.name)
            textView.text = items[pos].name
        }
    }

    /**
     * 초기 한 번만 호출하도록.
     */
    fun updateItems(newItems: List<Genre>) {
        items = newItems
        notifyItemInserted(0)
    }
}