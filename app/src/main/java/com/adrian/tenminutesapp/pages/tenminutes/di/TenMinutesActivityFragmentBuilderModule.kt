package com.adrian.tenminutesapp.pages.tenminutes.di

import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.di.HistoryPageModule
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.view.HistoryPageFragment
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.di.HomePageModule
import com.adrian.tenminutesapp.pages.tenminutes.subpages.home.view.HomePageFragment
import com.adrian.tenminutesapp.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 09. 21..
 */
@Module
abstract class TenMinutesActivityFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(HomePageModule::class))
    abstract fun bindHomePageFragment(): HomePageFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(HistoryPageModule::class))
    abstract fun bindHistoryPageFragment(): HistoryPageFragment


}