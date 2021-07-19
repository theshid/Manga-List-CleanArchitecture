package com.shid.animelistcleanarchitecture.core.remote

import com.shid.animelistcleanarchitecture.framework.network.api.ApiServices
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.CharactersListResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.DetailAnimeResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.Promo
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val services: ApiServices) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(api: ApiServices): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(api)
        }
    }

    suspend fun getTopAnime(type: String, callback: GetAnimeCallback) {
        withContext(Dispatchers.IO) {
            val animes = services.getTopAnime(type).top
            callback.onAnimeReceived(animes)
        }
    }

    suspend fun getDetailAnime(id: Int, callback: GetDetailCallback) {
        withContext(Dispatchers.IO) {
            val anime = services.getDetailAnime(id)
            callback.onAnimeReceived(anime)
        }
    }

    suspend fun getSeasonAnime(year: Int, season: String, callback: GetAnimeCallback) {
        withContext(Dispatchers.IO) {
            val anime = services.getSeasonAnime(year, season).anime
            callback.onAnimeReceived(anime)
        }
    }

    suspend fun getSearchAnime(query: String, callback: GetAnimeCallback) {
        withContext(Dispatchers.IO) {
            val anime = services.getSearchAnime(query).results
            callback.onAnimeReceived(anime)
        }
    }

    suspend fun getCharacters(id: Int, callback: GetCharactersCallback) {
        withContext(Dispatchers.IO) {
            val characters = services.getCharacters(id).characters
            callback.onCharactersReceived(characters)
        }
    }

    suspend fun getVideos(id: Int, callback: GetVideosCallback) {
        withContext(Dispatchers.IO) {
            val videos = services.getVideos(id).promo
            callback.onVideosReceived(videos)
        }
    }

    interface GetAnimeCallback {
        fun onAnimeReceived(animeList: List<AnimeListResponse>)
    }

    interface GetDetailCallback {
        fun onAnimeReceived(anime: DetailAnimeResponse)
    }

    interface GetCharactersCallback {
        fun onCharactersReceived(characters: List<CharactersListResponse>)
    }

    interface GetVideosCallback {
        fun onVideosReceived(videos: List<Promo>)
    }
}