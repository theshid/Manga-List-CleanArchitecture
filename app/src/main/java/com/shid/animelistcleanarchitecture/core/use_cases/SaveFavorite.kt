package com.shid.animelistcleanarchitecture.core.use_cases

import com.shid.animelistcleanarchitecture.core.repository.IAnimeRepository
import com.shid.animelistcleanarchitecture.framework.database.entities.BookmarkAnime
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.DetailAnimeResponse
import javax.inject.Inject

class SaveFavorite @Inject constructor(private val repository: IAnimeRepository){

    suspend fun invoke(detailAnime: DetailAnimeResponse){
        val anime = BookmarkAnime.ModelMapper.from(detailAnime)
        repository.addBookmark(anime)
    }
}