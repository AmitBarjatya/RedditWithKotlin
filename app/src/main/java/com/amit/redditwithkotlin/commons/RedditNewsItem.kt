package com.amit.redditwithkotlin.commons

/**
 * Created by Amit Barjatya on 8/31/17.
 */
data class RedditNewsItem(
        val author:String,
        val title:String,
        val numComments:Int,
        val created:Long,
        val thumbnail:String,
        val url:String
)