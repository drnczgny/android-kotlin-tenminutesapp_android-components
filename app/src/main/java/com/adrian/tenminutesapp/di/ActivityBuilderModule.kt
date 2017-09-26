package com.adrian.tenminutesapp.di

import com.adrian.tenminutesapp.pages.tenminutes.di.TenMinutesActivityFragmentBuilderModule
import com.adrian.tenminutesapp.pages.tenminutes.di.TenMinutesModule
import com.adrian.tenminutesapp.pages.tenminutes.view.TenMinutesActivity
import com.adrian.tenminutesapp.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(TenMinutesModule::class, TenMinutesActivityFragmentBuilderModule::class))
    abstract fun bindHomePageActivity(): TenMinutesActivity
}