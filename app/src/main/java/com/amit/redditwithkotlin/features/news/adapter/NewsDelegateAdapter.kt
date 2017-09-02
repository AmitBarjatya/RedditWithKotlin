package com.amit.redditwithkotlin.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.amit.redditwithkotlin.R
import com.amit.redditwithkotlin.commons.RedditNewsItem
import com.amit.redditwithkotlin.commons.adapter.ViewType
import com.amit.redditwithkotlin.commons.adapter.ViewTypeDelegateAdapter
import com.amit.redditwithkotlin.commons.extensions.getFriendlyTime
import com.amit.redditwithkotlin.commons.extensions.inflate
import com.amit.redditwithkotlin.commons.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by Amit Barjatya on 9/2/17.
 */
class NewsDelegateAdapter:ViewTypeDelegateAdapter{
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }


    inner class TurnsViewHolder(parent:ViewGroup):RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)){

        private val imgThumbnail = itemView.img_thumbnail
        private val description = itemView.description
        private val author = itemView.author
        private val comments = itemView.author
        private val time = itemView.time

        fun bind(item : RedditNewsItem){
            imgThumbnail.loadImg(item.thumbnail)
            description.text= item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()

        }
    }
}