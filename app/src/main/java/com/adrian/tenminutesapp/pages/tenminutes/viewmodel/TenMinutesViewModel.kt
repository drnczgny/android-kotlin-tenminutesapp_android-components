package com.adrian.tenminutesapp.pages.tenminutes.viewmodel

import com.adrian.tenminutesapp.base.BaseViewModel
import com.adrian.tenminutesapp.pages.tenminutes.view.TenMinutesRouter

/**
 * Created by cadri on 2017. 09. 19..
 */

class TenMinutesViewModel constructor(val tenMinutesRouter: TenMinutesRouter) : BaseViewModel() {

    object logging {
        val TAG = TenMinutesViewModel::class.java.simpleName
    }

    override fun onCreate() {
        // NO-OP
    }
}
