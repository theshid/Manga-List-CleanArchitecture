package com.shid.animelistcleanarchitecture.presentation.more

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shid.animelistcleanarchitecture.R
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse


class MoreAdapter (private val activity2:Activity,private val showDetail: (id: Int) -> Unit) :
    RecyclerView.Adapter<MoreAdapter.MoreViewHolder>() {

    private var listData = ArrayList<AnimeListResponse>()
    companion object {
        lateinit var activity: Activity
    }

    init {
        activity = activity2
    }

    fun setData(newListData: List<AnimeListResponse>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    fun getAnimeItem(position: Int): AnimeListResponse {
        return listData[position]
    }


    override fun onBindViewHolder(holder: MoreViewHolder, position: Int) {
        val item = listData[position]
        holder.bindTo(item)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoreViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_more, parent, false)
        return MoreViewHolder(view)
    }

    inner class MoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.findViewById(R.id.image)
        private val title: TextView = itemView.findViewById(R.id.txt_title)
        private val score: TextView = itemView.findViewById(R.id.score_more)


        fun bindTo(anime: AnimeListResponse) {
            image.load(anime.imageUrl)
            title.text = anime.title
            anime.score?.let { score.text = it.toString() }
            if ( anime.score.toString() == "null"){
                score.text = "N/A"
            }

            itemView.apply {
                rootView.setOnClickListener(View.OnClickListener {
                  anime.id?.let { it -> showDetail(it) }
                })
            }

        }

    }

    override fun getItemCount(): Int = listData.size
}