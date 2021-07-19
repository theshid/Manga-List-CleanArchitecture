package com.shid.animelistcleanarchitecture.core.repository

import com.shid.animelistcleanarchitecture.core.remote.RemoteDataSource
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.CharactersListResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.DetailAnimeResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.Promo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailAnimeRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): DetailRepository {

    companion object {
        @Volatile
        private var instance: DetailAnimeRepository? = null
        fun getInstance(remoteData: RemoteDataSource): DetailAnimeRepository =
            instance ?: synchronized(this) {
                instance ?: DetailAnimeRepository(remoteData)
            }
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