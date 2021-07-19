package com.shid.animelistcleanarchitecture.framework.network.responses.main_response

import com.shid.animelistcleanarchitecture.framework.database.entities.AnimeType
import com.squareup.moshi.Json

data class AnimeListResponse(
    @Json(name = "mal_id")
    val id: Int? = 0,
    @Json(name = "title")
    val title: String? = "",
    @Json(name = "image_url")
    val imageUrl: String? = "",
    @Json(name = "type")
    val type: String? = "",
    @Json(name = "episodes")
    val episodes: Int? = 0,
    @Json(name = "score")
    val score: Double? = 0.0
): AnimeType