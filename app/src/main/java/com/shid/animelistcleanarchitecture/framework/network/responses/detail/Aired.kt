package com.shid.animelistcleanarchitecture.framework.network.responses.detail

import com.squareup.moshi.Json

data class Aired(
    @Json(name = "from")
    val from: String? = "",
    @Json(name = "to")
    val to: String? = "",
    @Json(name = "string")
    val string: String? = ""
)