package com.amit.redditwithkotlin.di

import com.amit.redditwithkotlin.api.NewsAPI
import com.amit.redditwithkotlin.api.NewsRestAPI
import com.amit.redditwithkotlin.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Amit Barjatya on 9/3/17.
 */
@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI {
        return NewsRestAPI(redditApi)
    }

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi {
        return retrofit.create(RedditApi::class.java)
    }
}