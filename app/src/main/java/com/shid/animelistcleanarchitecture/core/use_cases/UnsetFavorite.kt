package com.shid.animelistcleanarchitecture.core.use_cases

import com.shid.animelistcleanarchitecture.framework.repository_implementation.IAnimeRepository
import com.shid.animelistcleanarchitecture.framework.database.entities.BookmarkAnime
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.DetailAnimeResponse
import javax.inject.Inject

class UnsetFavorite @Inject constructor(private val repository: IAnimeRepository) {

    suspend fun invoke(detailAnime: DetailAnimeResponse){
        val anime = BookmarkAnime.ModelMapper.from(detailAnime)
        repository.unBookmark(anime)
    }
}