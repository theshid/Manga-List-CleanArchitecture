package com.shid.animelistcleanarchitecture.framework.network.responses.top


import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import com.squareup.moshi.Json

data class TopAnimeResponse(
    @Json(name = "top")
    val top: List<AnimeListResponse>
)