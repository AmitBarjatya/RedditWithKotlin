package com.amit.redditwithkotlin.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by Amit Barjatya on 8/31/17.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}