package com.halil.ozel.retrofitapp

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tek_satir_playlist.view.*

class PlayListAdapter(tumOynatmaListeleri:List<PlayListData.Items>?) : RecyclerView.Adapter<PlayListAdapter.PlaylistViewHolder>() {




    var oynatmaListeleri=tumOynatmaListeleri

    override fun getItemCount(): Int {

        return oynatmaListeleri!!.size

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PlaylistViewHolder {
        var inflater= LayoutInflater.from(p0?.context)
        var tekSatirPlaylist=inflater.inflate(R.layout.tek_satir_playlist, p0, false)

        return PlaylistViewHolder(tekSatirPlaylist)
    }

    override fun onBindViewHolder(p0: PlaylistViewHolder, p1: Int) {
        var oanOlusturulanSatir=oynatmaListeleri?.get(p1)
        p0?.setData(oanOlusturulanSatir,p1)
    }




    inner class PlaylistViewHolder(itemView : View?) :RecyclerView.ViewHolder(itemView!!){

        var tekSatirPlaylist=itemView as CardView

        var playListTitle=tekSatirPlaylist.tvListeBaslik
        var playListResim = tekSatirPlaylist.circleResim



        fun setData(oanOlusturulanSatir: PlayListData.Items?, pos:Int){
            playListTitle.text=oanOlusturulanSatir?.snippet?.title
            Picasso.with(tekSatirPlaylist.context).load(oanOlusturulanSatir?.snippet?.thumbnails?.high?.url).into(playListResim)
        }

    }


}