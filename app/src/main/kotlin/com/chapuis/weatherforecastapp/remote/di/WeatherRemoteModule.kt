package com.chapuis.weatherforecastapp.remote.di

import com.chapuis.weatherforecastapp.data.WeatherRemoteStore
import com.chapuis.weatherforecastapp.remote.WeatherDataRemoteStoreImpl
import dagger.Binds
import dagger.Module

@Module
abstract class WeatherRemoteModule {

    @Binds
    abstract fun provideWeatherRemoteStore(remoteStoreImpl: WeatherDataRemoteStoreImpl): WeatherRemoteStore
}