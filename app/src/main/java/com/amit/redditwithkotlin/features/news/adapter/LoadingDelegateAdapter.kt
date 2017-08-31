package com.amit.redditwithkotlin.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.amit.redditwithkotlin.R
import com.amit.redditwithkotlin.commons.adapter.ViewType
import com.amit.redditwithkotlin.commons.adapter.ViewTypeDelegateAdapter
import com.amit.redditwithkotlin.commons.extensions.inflate

/**
 * Created by Amit Barjatya on 8/31/17.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading)) {
    }
}