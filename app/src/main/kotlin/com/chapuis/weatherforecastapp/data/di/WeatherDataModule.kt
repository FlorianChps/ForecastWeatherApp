package com.chapuis.weatherforecastapp.data.di

import com.chapuis.weatherforecastapp.data.WeatherRepositoryImpl
import com.chapuis.weatherforecastapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module

@Module
abstract class WeatherDataModule {

    @Binds
    abstract fun provideWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}