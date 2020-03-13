package com.chapuis.weatherforecastapp.base.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Singleton
    @Provides
    fun provideContext() = application.applicationContext
}