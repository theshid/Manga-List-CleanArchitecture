package com.shid.animelistcleanarchitecture.core.use_cases

import com.shid.animelistcleanarchitecture.core.repository.IAnimeRepository
import com.shid.animelistcleanarchitecture.framework.database.entities.BookmarkAnime
import javax.inject.Inject

class GetBookmarks @Inject constructor(private val repository: IAnimeRepository) {

    fun getBookmarks():List<BookmarkAnime>{
        return repository.getBookmarks()
    }
}