package com.shid.animelistcleanarchitecture.core.use_cases

import com.shid.animelistcleanarchitecture.framework.repository_implementation.SearchAnimeRepository
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import javax.inject.Inject

class GetSearchAnimes @Inject constructor(private val repository: SearchAnimeRepository) {
    suspend fun getSearchAnimes(query:String):List<AnimeListResponse>{
        return repository.getSearchAnime(query)
    }
}