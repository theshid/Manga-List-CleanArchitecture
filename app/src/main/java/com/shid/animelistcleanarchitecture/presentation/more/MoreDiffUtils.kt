package com.shid.animelistcleanarchitecture.presentation.more

import androidx.recyclerview.widget.DiffUtil
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse

object MoreDiffUtils : DiffUtil.ItemCallback<AnimeListResponse>() {


    override fun areItemsTheSame(
        oldItem: AnimeListResponse,
        newItem: AnimeListResponse
    ): Boolean = oldItem == newItem


    override fun areContentsTheSame(
        oldItem: AnimeListResponse,
        newItem: AnimeListResponse
    ): Boolean = oldItem.id == newItem.id

}