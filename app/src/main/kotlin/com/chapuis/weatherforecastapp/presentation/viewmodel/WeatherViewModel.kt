package com.chapuis.weatherforecastapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chapuis.weatherforecastapp.domain.interactor.WeatherInteractor
import com.chapuis.weatherforecastapp.presentation.mapper.WeatherMapper
import com.chapuis.weatherforecastapp.presentation.viewmodel.state.WeatherState
import com.chapuis.weatherforecastapp.utils.ioToMainThreadObservableTransformer
import com.chapuis.weatherforecastapp.utils.store
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val interactor: WeatherInteractor,
    private val mapper: WeatherMapper
) : ViewModel() {

    val weatherLiveData: LiveData<WeatherState> get() = _weatherLiveData

    private val _weatherLiveData = MutableLiveData<WeatherState>()
    private val schedulerTransformer = ioToMainThreadObservableTransformer<WeatherState>()
    private val compositeDisposable = CompositeDisposable()

    fun getWeather() {
        interactor.getWeather()
            .map<WeatherState> { list -> WeatherState.Success(mapper.mapModelToUiModel(list)) }
            .onErrorReturn { error -> WeatherState.Error(error) }
            .toObservable()
            .startWith(WeatherState.Loading)
            .compose(schedulerTransformer)
            .subscribe { state -> _weatherLiveData.value = state }
            .store(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}