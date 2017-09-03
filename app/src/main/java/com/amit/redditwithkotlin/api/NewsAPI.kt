package com.amit.redditwithkotlin.api

import retrofit2.Call

/**
 * Created by Amit Barjatya on 9/3/17.
 */
interface NewsAPI{
    fun getNews(after:String,limit:String):Call<RedditNewsResponse>
}