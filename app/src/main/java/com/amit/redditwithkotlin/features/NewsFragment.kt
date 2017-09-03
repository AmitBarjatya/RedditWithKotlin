package com.amit.redditwithkotlin.features

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amit.redditwithkotlin.R
import com.amit.redditwithkotlin.commons.RedditNews
import com.amit.redditwithkotlin.commons.RxBaseFragment
import com.amit.redditwithkotlin.commons.adapter.InfiniteScrollListener
import com.amit.redditwithkotlin.commons.extensions.inflate
import com.amit.redditwithkotlin.features.news.adapter.NewsAdapter
import com.amit.redditwithkotlin.features.news.adapter.NewsManager
import kotlinx.android.synthetic.main.news_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Amit Barjatya on 8/31/17.
 */
class NewsFragment : RxBaseFragment() {

    private var redditNews: RedditNews? = null
    private val newsManager by lazy{ NewsManager() }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        val linearLayout = LinearLayoutManager(context)
        news_list.layoutManager = linearLayout
        news_list.clearOnScrollListeners()
        news_list.addOnScrollListener(InfiniteScrollListener({requestNews()},linearLayout))
        initAdapter()

        if(savedInstanceState==null){
            requestNews()
        }
    }

    private fun requestNews(){
        val subscription = newsManager.getNews(redditNews?.after?:"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ( {
                    retrievedNews ->
                        redditNews = retrievedNews
                        (news_list.adapter as NewsAdapter).addNews(retrievedNews.news)
                },{
                    e -> Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                })
        subscriptions.add(subscription)
    }

    private fun initAdapter(){
        if(news_list.adapter == null)
            news_list.adapter = NewsAdapter()
    }
}