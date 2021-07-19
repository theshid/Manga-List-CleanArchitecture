package com.shid.animelistcleanarchitecture.core.repository

import com.shid.animelistcleanarchitecture.framework.network.responses.detail.CharactersListResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.DetailAnimeResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.Promo
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse

interface AnimeRepository {

    suspend fun getTopAnime(type:String): List<AnimeListResponse>

    suspend fun getDetailAnime(id: Int): DetailAnimeResponse

    suspend fun getSeasonAnime(year: Int, season: String): List<AnimeListResponse>

    suspend fun getSearchAnime(query: String): List<AnimeListResponse>

    suspend fun getCharacters(id: Int): List<CharactersListResponse>

    suspend fun getVideos(id: Int): List<Promo>
}





    //suspend fun getSeasonAnime(year: Int, season: String): List<AnimeListResponse>




