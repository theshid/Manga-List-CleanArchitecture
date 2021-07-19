package com.shid.animelistcleanarchitecture.framework.network.responses.detail

import com.shid.animelistcleanarchitecture.framework.network.responses.detail.Promo
import com.squareup.moshi.Json

data class VideosResponse(
    @Json(name = "promo")
    val promo: List<Promo>
)