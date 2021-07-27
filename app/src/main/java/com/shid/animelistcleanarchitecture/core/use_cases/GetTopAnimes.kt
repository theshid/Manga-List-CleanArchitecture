package com.shid.animelistcleanarchitecture.core.use_cases

import com.shid.animelistcleanarchitecture.framework.repository_implementation.IAnimeRepository
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import javax.inject.Inject

class GetTopAnimes @Inject constructor(private val repository: IAnimeRepository) {

    suspend fun getTopAnimes(type:String):List<AnimeListResponse>{
        return repository.getTopAnime(type)
    }
}