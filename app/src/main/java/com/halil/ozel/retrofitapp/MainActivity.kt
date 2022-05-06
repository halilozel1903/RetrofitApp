package com.halil.ozel.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val API_KEY = "AIzaSyAVH-8d2L9i23FC-ChJEPIMLIzYuHgUrvg"
    private val CHANNEL_ID = "UCZNZj3mkdCGJfCoKyl4bSYQ"
    var data : PlayListData? = null
    var playList : List<PlayListData.Items>? = null

    var myAdapter : PlayListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // refrofit ile interface arasında bağlantı kuruldu.
        val apiInterface = ApiClient.client?.create(ApiInterface::class.java) // retrofit varsa devam et yoksa oluştur ve işlemi başlat
        val apiCall = apiInterface?.getList(CHANNEL_ID,API_KEY,20)

        apiCall?.enqueue(object : Callback<PlayListData>{
            override fun onFailure(call: Call<PlayListData>, t: Throwable) { // basarısızsa
                Log.e("HATALI",""+ t.printStackTrace())
            }

            override fun onResponse(call: Call<PlayListData>, response: Response<PlayListData>) { // basarılıysa
                data = response.body()
                playList = data?.items
                myAdapter = PlayListAdapter(playList)
                recyclerviewPlaylist.adapter = myAdapter

                val myLayoutManager =
                    LinearLayoutManager(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                recyclerviewPlaylist.layoutManager = myLayoutManager

                supportActionBar?.subtitle = "Toplam Liste : "+playList?.size

            }
        })

    }
}
