package com.adrian.tenminutesapp.di

import android.content.Context
import android.content.SharedPreferences
import com.adrian.tenminutesapp.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
class AppModule {

    @Singleton
    @Provides
    @Named("ApplicationContext")
    fun provideContext(myApplication: MyApplication): Context = myApplication

    @Singleton
    @Provides
    fun provideSharedPreferences(@Named("ApplicationContext") context: Context): SharedPreferences {
        return context.getSharedPreferences("PREFS", Context.MODE_PRIVATE)
    }
}