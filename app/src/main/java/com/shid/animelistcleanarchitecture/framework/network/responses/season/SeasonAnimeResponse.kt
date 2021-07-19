package com.shid.animelistcleanarchitecture.framework.network.responses.season


import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import com.squareup.moshi.Json

data class SeasonAnimeResponse(
    @Json(name = "season_name")
    val season: String,
    @Json(name = "season_year")
    val year: Int,
    @Json(name = "anime")
    val anime: List<AnimeListResponse>
)