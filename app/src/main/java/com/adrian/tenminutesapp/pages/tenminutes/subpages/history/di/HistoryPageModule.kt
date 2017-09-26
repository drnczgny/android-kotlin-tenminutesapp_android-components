package com.adrian.tenminutesapp.pages.tenminutes.subpages.history.di

import com.adrian.tenminutesapp.pages.tenminutes.model.TenMinutesModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.model.HistoryPageModel
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.view.HistoryPageFragment
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.view.HistoryPageRouter
import com.adrian.tenminutesapp.pages.tenminutes.subpages.history.viewmodel.HistoryPageViewModel
import com.adrian.tenminutesapp.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 09. 23..
 */

@Module
class HistoryPageModule {

    @FragmentScope
    @Provides
    fun provideHistoryPageRouter(historyPageFragment: HistoryPageFragment): HistoryPageRouter = historyPageFragment

    @FragmentScope
    @Provides
    fun provideHistoryPageModel(tenMinutesModel: TenMinutesModel) = HistoryPageModel(tenMinutesModel)

    @FragmentScope
    @Provides
    fun provideHistoryPageViewModel(router: HistoryPageRouter, model: HistoryPageModel)
            = HistoryPageViewModel(router, model)
}