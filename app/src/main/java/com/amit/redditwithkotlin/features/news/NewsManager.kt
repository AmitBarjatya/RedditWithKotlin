package com.amit.redditwithkotlin.features.news.adapter

import com.amit.redditwithkotlin.commons.RedditNewsItem
import rx.Observable

/**
 * Created by Amit Barjatya on 9/3/17.
 */

class NewsManager() {
    fun getNews() : Observable<List<RedditNewsItem>> {
        return Observable.create{
            subscriber ->

            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10){
                news.add(RedditNewsItem(
                        "author$i",
                        "title$i",
                        i,
                        1457207701L - i * 200,
                        "http://lorempixel.com/200/200/technics/$i",
                        "url"
                ))
            }
            subscriber.onNext(news)
        }
    }
}