package com.halil.ozel.retrofitapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val BASE_URL = "https://www.googleapis.com/youtube/v3/"
    private var retrofit : Retrofit? = null

    val client : Retrofit?
        get() {

            if (retrofit == null){

                retrofit=Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return retrofit

        }

}