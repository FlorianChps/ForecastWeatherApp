package com.chapuis.weatherforecastapp.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chapuis.weatherforecastapp.presentation.viewmodel.WeatherViewModel
import javax.inject.Inject
import javax.inject.Provider

class WeatherViewModelFactory @Inject constructor(
    private val provider: Provider<WeatherViewModel>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = provider.get() as T
}