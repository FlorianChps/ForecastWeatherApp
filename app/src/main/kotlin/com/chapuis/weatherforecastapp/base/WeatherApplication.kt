package com.chapuis.weatherforecastapp.base

import android.app.Application
import com.chapuis.weatherforecastapp.base.di.*

class WeatherApplication : Application() {

    val appComponent: ApplicationComponent by lazy { buildAppComponent() }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    private fun buildAppComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .apiModule(ApiModule())
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule())
            .build()
    }
}