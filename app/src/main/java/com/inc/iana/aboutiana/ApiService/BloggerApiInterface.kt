package com.inc.iana.aboutiana.ApiService

import com.inc.iana.aboutiana.Model.Item
import com.inc.iana.aboutiana.Model.PostList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BloggerApiInterface {
    @GET("?key="+"AIzaSyANHwiScYFaHh2FUbl7zMMYZyBLjoaZ6uk")
    fun getPostList():Call<PostList>

    @GET("?labels={label}/users")
    fun getPostByLabel(@Path("label") label:String):Call<Item>

    @GET("?labels={label1}+{label2)&key="+"AIzaSyANHwiScYFaHh2FUbl7zMMYZyBLjoaZ6uk")
    fun getPostByLabels(@Path("label1") label1:String, @Path("label2") label2:String):Call<Item>
}