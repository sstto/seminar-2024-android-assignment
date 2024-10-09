package com.wafflestudio.waffleseminar2024.main.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wafflestudio.waffleseminar2024.main.search.data.Genre
import com.wafflestudio.waffleseminar2024.main.search.data.GenreList
import com.wafflestudio.waffleseminar2024.main.search.data.genresJsonString
import kotlinx.serialization.json.Json

class SearchViewModel : ViewModel() {

    private val _genres = MutableLiveData<List<Genre>>()
    val genres: LiveData<List<Genre>> = _genres

    init {
        loadGenres()
    }

    private fun loadGenres() {
        _genres.value = Json.decodeFromString<GenreList>(genresJsonString).genres
//        _genres.value = listOf(Genre(1, "a"))
    }

}