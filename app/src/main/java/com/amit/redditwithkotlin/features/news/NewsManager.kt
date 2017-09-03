package com.amit.redditwithkotlin.features.news.adapter

import com.amit.redditwithkotlin.api.RedditApi
import com.amit.redditwithkotlin.api.RestApi
import com.amit.redditwithkotlin.commons.RedditNewsItem
import rx.Observable

/**
 * Created by Amit Barjatya on 9/3/17.
 */

class NewsManager(private val api : RestApi = RestApi()) {
    fun getNews(limit : String = "10") : Observable<List<RedditNewsItem>> {
        return Observable.create{
            subscriber ->

            val callResponse  = api.getNews("",limit)
            val response = callResponse.execute()
            if (response.isSuccessful){
                val news = response.body().data.children.map {
                    val item = it.data
                    RedditNewsItem(item.author,item.title,item.num_comments
                            ,item.created,item.thumbnail,item.url)
                }
                subscriber.onNext(news)
                subscriber.onCompleted()
            }else{
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}