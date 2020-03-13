package com.chapuis.weatherforecastapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.chapuis.weatherforecastapp.R
import com.chapuis.weatherforecastapp.base.WeatherApplication
import com.chapuis.weatherforecastapp.databinding.ActivityMainBinding
import com.chapuis.weatherforecastapp.presentation.model.WeatherUiModel
import com.chapuis.weatherforecastapp.presentation.viewmodel.WeatherViewModel
import com.chapuis.weatherforecastapp.presentation.viewmodel.factory.WeatherViewModelFactory
import com.chapuis.weatherforecastapp.presentation.viewmodel.state.WeatherState
import com.chapuis.weatherforecastapp.utils.getViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: WeatherViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherViewModel
    private val observer = createObserver()

    private lateinit var dayWeatherAdapter: DayPagerAdapter

    private val mainComponent: MainComponent by lazy {
        DaggerMainComponent.builder()
            .applicationComponent(WeatherApplication().appComponent)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainComponent.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = getViewModel(WeatherViewModel::class.java, factory)
        viewModel.getWeather()
        viewModel.weatherLiveData.observe(this, observer)
    }

    private fun createObserver() =
        Observer<WeatherState> { weatherState ->
            when (weatherState) {
                is WeatherState.Loading -> handleLoading()
                is WeatherState.Error -> handleErrorCase(weatherState.error)
                is WeatherState.Success -> renderWeatherPager(weatherState.weather)
            }
        }

    private fun renderWeatherPager(weather: List<WeatherUiModel>) {
        loadingProgress.visibility = View.GONE
        dayWeatherAdapter = DayPagerAdapter(this, weather)
        pager.adapter = dayWeatherAdapter
    }

    private fun handleErrorCase(error: Throwable) {
        loadingProgress.visibility = View.GONE

    }

    private fun handleLoading() {
        loadingProgress.visibility = View.VISIBLE
    }
}
