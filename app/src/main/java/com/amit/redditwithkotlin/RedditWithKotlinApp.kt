package com.amit.redditwithkotlin

import android.app.Application
import com.amit.redditwithkotlin.di.AppModule
import com.amit.redditwithkotlin.di.DaggerNewsComponent
import com.amit.redditwithkotlin.di.NewsComponent

/**
 * Created by Amit Barjatya on 9/3/17.
 */
class RedditWithKotlinApp : Application() {

    companion object {
        lateinit var newsComponent  : NewsComponent
    }

    override fun onCreate() {
        super.onCreate()

        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                .build()

    }
}