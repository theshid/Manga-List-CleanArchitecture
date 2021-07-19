package com.shid.animelistcleanarchitecture.framework.network.responses.detail


import com.squareup.moshi.Json

data class CharactersResponse(
    @Json(name = "characters")
    val characters: List<CharactersListResponse>
)