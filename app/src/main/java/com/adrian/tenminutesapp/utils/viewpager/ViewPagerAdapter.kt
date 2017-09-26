package com.adrian.tenminutesapp.utils.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.adrian.tenminutesapp.base.BaseFragment

/**
 * Created by cadri on 2017. 08. 22..
 */

class ViewPagerAdapter
constructor(val fm: FragmentManager, val dataModel: TenMinutesViewPagerDataModel) : FragmentPagerAdapter(fm) {

    object logging {
        val TAG = ViewPagerAdapter::class.java.simpleName
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return dataModel.fragmentList().get(0)
            }
            1 -> {
                return dataModel.fragmentList().get(1)
            }
//            2 -> {
//                return dataModel.fragmentList().get(2)
//            }
            else -> throw UnsupportedOperationException() as Throwable
        }
        return dataModel.fragmentList().get(0)
    }

    override fun getCount(): Int {
        return dataModel.fragmentList().size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return dataModel.titleList().get(position)
    }

    fun onPageSelected(position: Int) {
        when (position) {
            0 -> (dataModel.fragmentList().get(0) as BaseFragment).onSelectedInViewPager()
            1 -> (dataModel.fragmentList().get(1) as BaseFragment).onSelectedInViewPager()
//            2 -> (dataModel.fragmentList().get(2) as BaseFragment).onSelectedInViewPager()
        }
    }
}