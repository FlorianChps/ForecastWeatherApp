package com.chapuis.weatherforecastapp.domain.di

import com.chapuis.weatherforecastapp.domain.interactor.WeatherInteractor
import com.chapuis.weatherforecastapp.domain.interactor.WeatherInteractorImpl
import dagger.Binds
import dagger.Module

@Module
abstract class WeatherInteractorModule {

    @Binds
    abstract fun provideWeatherInteractor(weatherInteractorImpl: WeatherInteractorImpl): WeatherInteractor
}