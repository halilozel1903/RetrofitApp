package com.halil.ozel.retrofitapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    // GET https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCZNZj3mkdCGJfCoKyl4bSYQ&maxResults=20&key={YOUR_API_KEY}

    @GET("playlists?part=snippet")
    fun tumListeleriGetir(@Query("channelId")channelID : String, @Query("key")apiKey:String,@Query("maxResults")limit:Int):Call<PlayListData>

}