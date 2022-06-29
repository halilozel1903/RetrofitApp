package com.halil.ozel.retrofitapp

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tek_satir_playlist.view.*

class PlayListAdapter(allPlayList: List<PlayListData.Items>?) :
    RecyclerView.Adapter<PlayListAdapter.PlaylistViewHolder>() {

    private var playList = allPlayList

    override fun getItemCount(): Int {
        return playList?.size ?: 0
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PlaylistViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val oneLinePlaylist = inflater.inflate(R.layout.tek_satir_playlist, p0, false)

        return PlaylistViewHolder(oneLinePlaylist)
    }

    override fun onBindViewHolder(p0: PlaylistViewHolder, p1: Int) {
        val currentList = playList?.get(p1)
        p0.setData(currentList, p1)
    }


    inner class PlaylistViewHolder(itemView: View?) :
        RecyclerView.ViewHolder(itemView!!) {

        private var oneLineList = itemView as CardView
        private var playListTitle = oneLineList.tvListeBaslik
        private var playListPhoto = oneLineList.circleResim

        fun setData(currentCreateList: PlayListData.Items?, pos: Int) {
            playListTitle.text = currentCreateList?.snippet?.title
            Picasso.get().load(currentCreateList?.snippet?.thumbnails?.high?.url)
                .into(playListPhoto)
        }
    }
}