package com.amit.redditwithkotlin.commons

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by Amit on 8/31/17.
 */
open class RxBaseFragment : Fragment() {

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        subscriptions.clear()
        super.onPause()
    }
}