package com.shid.animelistcleanarchitecture.core.repository

import com.shid.animelistcleanarchitecture.core.remote.RemoteDataSource
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.CharactersListResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.DetailAnimeResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.Promo
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IAnimeRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): AnimeRepository {

    override suspend fun getTopAnime(type: String): List<AnimeListResponse> {
        lateinit var animeResult: List<AnimeListResponse>
        remoteDataSource.getTopAnime(type, object : RemoteDataSource.GetAnimeCallback {
            override fun onAnimeReceived(animeList: List<AnimeListResponse>) {
                animeResult = animeList
            }
        })
        return animeResult
    }

    override suspend fun getDetailAnime(id: Int): DetailAnimeResponse {
        lateinit var animeDetail: DetailAnimeResponse
        remoteDataSource.getDetailAnime(id, object : RemoteDataSource.GetDetailCallback {
            override fun onAnimeReceived(anime: DetailAnimeResponse) {
                animeDetail = anime
            }
        })
        return animeDetail
    }

    override suspend fun getSeasonAnime(year: Int, season: String): List<AnimeListResponse> {
        lateinit var animeSeason: List<AnimeListResponse>
        remoteDataSource.getSeasonAnime(year, season, object : RemoteDataSource.GetAnimeCallback {
            override fun onAnimeReceived(animeList: List<AnimeListResponse>) {
                animeSeason = animeList
            }
        })
        return animeSeason
    }

    override suspend fun getSearchAnime(query: String): List<AnimeListResponse> {
        lateinit var animeResult: List<AnimeListResponse>
        remoteDataSource.getSearchAnime(query, object : RemoteDataSource.GetAnimeCallback {
            override fun onAnimeReceived(animeList: List<AnimeListResponse>) {
                animeResult = animeList
            }
        })
        return animeResult
    }

    override suspend fun getCharacters(id: Int): List<CharactersListResponse> {
        lateinit var charactersResult: List<CharactersListResponse>
        remoteDataSource.getCharacters(id, object : RemoteDataSource.GetCharactersCallback {
            override fun onCharactersReceived(characters: List<CharactersListResponse>) {
                charactersResult = characters
            }
        })
        return charactersResult
    }

    override suspend fun getVideos(id: Int): List<Promo> {
        lateinit var videosResult: List<Promo>
        remoteDataSource.getVideos(id, object : RemoteDataSource.GetVideosCallback {
            override fun onVideosReceived(videos: List<Promo>) {
                videosResult = videos
            }
        })
        return videosResult
    }


}