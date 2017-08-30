@file:JvmName("ExtensionsUtils")

package com.amit.redditwithkotlin.commons.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by kyrosdev on 8/30/17.
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false) :  View{
    return LayoutInflater.from(context).inflate(layoutId,this,attachToRoot)
}

