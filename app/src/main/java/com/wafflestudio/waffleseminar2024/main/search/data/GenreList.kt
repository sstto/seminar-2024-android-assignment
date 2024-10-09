package com.wafflestudio.waffleseminar2024.main.search.data

import kotlinx.serialization.Serializable

@Serializable
data class GenreList(
    val genres: List<Genre>
)

@Serializable
data class Genre(
    val id: Long,
    val name: String,
)
