package com.inc.iana.aboutiana.ApiService

import com.inc.iana.aboutiana.Model.*
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit


object BloggerApiService {

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/blogger/v3/blogs/1572826151972898654/posts")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val apiInterface: BloggerApiInterface

    init {
        apiInterface = retrofit.create(BloggerApiInterface::class.java)
    }
}