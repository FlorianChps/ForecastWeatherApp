package com.chapuis.weatherforecastapp.ui

import com.chapuis.weatherforecastapp.base.di.ActivityScope
import com.chapuis.weatherforecastapp.base.di.ApplicationComponent
import com.chapuis.weatherforecastapp.data.di.WeatherDataModule
import com.chapuis.weatherforecastapp.domain.di.WeatherInteractorModule
import com.chapuis.weatherforecastapp.local.di.WeatherLocalModule
import com.chapuis.weatherforecastapp.remote.di.WeatherRemoteModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        WeatherDataModule::class,
        WeatherRemoteModule::class,
        WeatherInteractorModule::class,
        WeatherLocalModule::class
    ]
)
interface MainComponent {

    fun inject(activity: MainActivity)
}