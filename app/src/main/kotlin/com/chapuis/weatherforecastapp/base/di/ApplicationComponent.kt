package com.chapuis.weatherforecastapp.base.di

import android.app.Application
import com.chapuis.weatherforecastapp.base.WeatherApplication
import com.chapuis.weatherforecastapp.remote.service.WeatherService
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        ApiModule::class
    ]
)
interface ApplicationComponent {

    fun application(): Application
    fun retrofit(): Retrofit
    fun service(): WeatherService

    fun inject(application: WeatherApplication)
}