package com.adrian.tenminutesapp.pages.tenminutes.di

import com.adrian.tenminutesapp.pages.tenminutes.model.TenMinutesModel
import com.adrian.tenminutesapp.pages.tenminutes.view.TenMinutesActivity
import com.adrian.tenminutesapp.pages.tenminutes.view.TenMinutesRouter
import com.adrian.tenminutesapp.pages.tenminutes.viewmodel.TenMinutesViewModel
import com.adrian.tenminutesapp.scope.ActivityScope
import com.adrian.tenminutesapp.utils.viewpager.TenMinutesViewPagerDataModel
import com.adrian.tenminutesapp.utils.viewpager.ViewPagerAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 09. 19..
 */

@Module
class TenMinutesModule {

    @ActivityScope
    @Provides
    fun providesTenMinutesRouter(tenMinutesActivity: TenMinutesActivity): TenMinutesRouter = tenMinutesActivity

    @ActivityScope
    @Provides
    fun providesTenMinutesViewModel(tenMinutesRouter: TenMinutesRouter)
            = TenMinutesViewModel(tenMinutesRouter)

    @ActivityScope
    @Provides
    fun providesTenMinutesModel() = TenMinutesModel()

    @ActivityScope
    @Provides
    fun provideTenMinutesViewPagerDataModel() = TenMinutesViewPagerDataModel()

    @ActivityScope
    @Provides
    fun provideViewPagerAdapter(tenMinutesActivity: TenMinutesActivity, tenMinutesViewPagerDataModel: TenMinutesViewPagerDataModel): ViewPagerAdapter {
        return ViewPagerAdapter(tenMinutesActivity.supportFragmentManager, tenMinutesViewPagerDataModel)
    }
}