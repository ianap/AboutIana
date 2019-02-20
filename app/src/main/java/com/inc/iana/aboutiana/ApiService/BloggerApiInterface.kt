package com.inc.iana.aboutiana.ApiService

import com.inc.iana.aboutiana.Model.Item
import com.inc.iana.aboutiana.Model.PostList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface BloggerApiInterface {
    @GET("?key="+"")
    fun getPostList():Call<PostList>

    @GET("?labels={label}/users")
    fun getPostByLabel(@Path("label") label:String):Call<Item>

    @GET("?labels={label1}+{label2)&key="+"")
    fun getPostByLabels(@Path("label1") label1:String, @Path("label2") label2:String):Call<PostList>

    companion object {
        fun create(): BloggerApiInterface {

            val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com/blogger/v3/blogs/1572826151972898654/posts/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(BloggerApiInterface::class.java)
        }
    }
}