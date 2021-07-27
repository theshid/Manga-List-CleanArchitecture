package com.shid.animelistcleanarchitecture.core.use_cases

import com.shid.animelistcleanarchitecture.framework.repository_implementation.IAnimeRepository
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import javax.inject.Inject

class GetSeasonAnimes @Inject constructor(private val repository: IAnimeRepository) {

    suspend fun getSeasonAnimes(year: Int, season: String):List<AnimeListResponse>{
        return repository.getSeasonAnime(year,season)
    }
}