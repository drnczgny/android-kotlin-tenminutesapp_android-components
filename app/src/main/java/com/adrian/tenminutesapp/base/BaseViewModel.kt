package com.adrian.tenminutesapp.base

import android.databinding.BaseObservable

/**
 * Created by cadri on 2017. 08. 22..
 */

abstract class BaseViewModel : BaseObservable() {

    abstract fun onCreate()

}