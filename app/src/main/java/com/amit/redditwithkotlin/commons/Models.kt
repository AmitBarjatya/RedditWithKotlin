package com.amit.redditwithkotlin.commons

import com.amit.redditwithkotlin.commons.adapter.AdapterConstants
import com.amit.redditwithkotlin.commons.adapter.ViewType

/**
 * Created by Amit Barjatya on 8/31/17.
 */


data class RedditNews(
        val after : String,
        val before : String,
        val news : List<RedditNewsItem>
)

data class RedditNewsItem(
        val author:String,
        val title:String,
        val numComments:Int,
        val created:Long,
        val thumbnail:String,
        val url:String
): ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}