package com.shid.animelistcleanarchitecture.core.domain.repository

import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse

interface SearchRepository {
    suspend fun getSearchAnime(query: String): List<AnimeListResponse>
}