package com.amit.redditwithkotlin.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Amit Barjatya on 9/3/17.
 */
interface RedditApi{

    @GET("/top.json")
    fun getTop(@Query("after")after:String,
               @Query("limit")limit:String) : Call<RedditNewsResponse>
}