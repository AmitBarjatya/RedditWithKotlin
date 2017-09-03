package com.amit.redditwithkotlin.di

import com.amit.redditwithkotlin.features.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Amit Barjatya on 9/3/17.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}