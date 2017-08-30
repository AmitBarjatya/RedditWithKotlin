package com.amit.redditwithkotlin.features

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amit.redditwithkotlin.R
import com.amit.redditwithkotlin.commons.extensions.RxBaseFragment
import com.amit.redditwithkotlin.commons.extensions.inflate
import kotlinx.android.synthetic.main.news_fragment.*

/**
 * Created by Amit Barjatya on 8/31/17.
 */
class NewsFragment : RxBaseFragment()  {

    private val newsList by lazy{
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsList.setHasFixedSize(true)
        newsList.layoutManager = LinearLayoutManager(context)
    }
}