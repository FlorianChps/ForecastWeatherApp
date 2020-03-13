package com.chapuis.weatherforecastapp.ui.day

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieDrawable.INFINITE
import com.chapuis.weatherforecastapp.R
import com.chapuis.weatherforecastapp.databinding.FragmentDayWeatherBinding
import com.chapuis.weatherforecastapp.presentation.model.WeatherUiModel
import kotlinx.android.synthetic.main.fragment_day_weather.*
import java.util.*

private const val FORMATTED_DATE = "EEEE dd MMMM yyyy"

class DayWeatherFragment : Fragment() {

    private lateinit var binding: FragmentDayWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDayWeatherBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dayWeatherModel = arguments?.getParcelable<WeatherUiModel>(DAY_WEATHER_MODEL)
        initView(requireNotNull(dayWeatherModel))
    }

    private fun initView(weatherUiModel: WeatherUiModel) {
        val cal = Calendar.getInstance(Locale.FRANCE)
        cal.timeInMillis = weatherUiModel.time * 1000L
        val date: String = DateFormat.format(FORMATTED_DATE, cal).toString()
        with(weatherUiModel) {
            weatherAnimation.setAnimation(weatherUiModel.type.lottieRes)
            weatherAnimation.playAnimation()
            weatherAnimation.repeatCount = INFINITE
            tvDay.text = date
            tvHumidity.text =
                getString(R.string.formatted_humidity_string, (humidity * 100).toInt())
            tvSummary.text = summary
            tvTemperature.text = convertToTemperature(temperatureMax, temperatureMin)
            tvTemperatureBig.text = convertToTemperature(temperatureMax, temperatureMin)
            tvWind.text = getString(R.string.formatted_wind_string, windSpeed.toInt())
        }
    }

    private fun convertToTemperature(temperatureMax: Double, temperatureMin: Double): String {
        return getString(
            R.string.formatted_temperature_string, ((temperatureMax + temperatureMin) / 2).toInt()
        )
    }

    companion object {

        private const val DAY_WEATHER_MODEL = "DAY_WEATHER_MODEL"

        @JvmStatic
        fun newInstance(weatherUiModel: WeatherUiModel): DayWeatherFragment {
            return DayWeatherFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(DAY_WEATHER_MODEL, weatherUiModel)
                }
            }
        }
    }
}
