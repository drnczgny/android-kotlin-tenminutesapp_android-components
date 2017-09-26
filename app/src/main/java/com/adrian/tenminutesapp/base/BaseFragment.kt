package com.adrian.tenminutesapp.base

import android.support.v4.app.Fragment

/**
 * Created by cadri on 2017. 09. 02..
 */

abstract class BaseFragment : Fragment() {

    /**
     * This method is called when the current fragment is selected in a ViewPager.
     * First time this method doesn't called on the first page in the ViewPager.
     */
    abstract fun onSelectedInViewPager()

}