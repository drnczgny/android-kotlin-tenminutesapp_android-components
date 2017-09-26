package com.adrian.tenminutesapp.utils.viewpager

import android.support.v4.app.Fragment
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.view.HistoryPageFragment
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.view.HomePageFragment

/**
 * Created by cadri on 2017. 08. 22..
 */

class TenMinutesViewPagerDataModel {

    fun titleList() = listOf<String>("Home", "History")

    private val homePageFragment: HomePageFragment = HomePageFragment.newInstance()
    private val historyPageFragment: HistoryPageFragment = HistoryPageFragment.newInstance()

    fun fragmentList() = listOf<Fragment>(
            homePageFragment,
            historyPageFragment
    )
}
