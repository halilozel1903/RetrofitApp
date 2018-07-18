package com.halil.ozel.retrofitapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val API_KEY = "AIzaSyAVH-8d2L9i23FC-ChJEPIMLIzYuHgUrvg"
    val CHANNEL_ID = "UCZNZj3mkdCGJfCoKyl4bSYQ"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // refrofit ile interface arasında bağlantı kuruldu.
        var apiInterface = ApiClient.client?.create(ApiInterface::class.java) // retrofit varsa devam et yoksa oluştur ve işlemi başlat
        var apiCall = apiInterface?.tumListeleriGetir(CHANNEL_ID,API_KEY,20)

        apiCall?.enqueue(object : Callback<PlayListData>{

            override fun onFailure(call: Call<PlayListData>?, t: Throwable?) { // basarısızsa

                Log.e("HATALI",""+t?.printStackTrace())
            }

            override fun onResponse(call: Call<PlayListData>?, response: Response<PlayListData>?) { // basarılıysa


                Log.e("BASARILI",""+call?.request()?.url()?.toString())

                for (i in 0..response?.body()?.items?.size!!-1){
                    Log.e("BASARILI",""+response?.body()?.items?.get(0)?.snippet?.title?.toString())
                }

            }


        })
    }
}
