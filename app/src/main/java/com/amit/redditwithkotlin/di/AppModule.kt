package com.amit.redditwithkotlin.di

import android.app.Application
import android.content.Context
import com.amit.redditwithkotlin.RedditWithKotlinApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Amit Barjatya on 9/3/17.
 */
@Module
class AppModule(val app:Application){

    @Provides
    @Singleton
    fun provideContext() : Context = app

    @Provides
    @Singleton
    fun provideApplication() : RedditWithKotlinApp = app as RedditWithKotlinApp

}