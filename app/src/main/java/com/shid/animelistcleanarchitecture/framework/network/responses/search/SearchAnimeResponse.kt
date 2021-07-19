package com.shid.animelistcleanarchitecture.framework.network.responses.search


import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import com.squareup.moshi.Json

data class SearchAnimeResponse(
    @Json(name = "results")
    val results: List<AnimeListResponse>
)