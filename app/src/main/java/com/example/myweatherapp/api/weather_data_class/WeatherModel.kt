package com.example.myweatherapp.api.weather_data_class

import com.example.myweatherapp.api.weather_data_class.Current
import com.example.myweatherapp.api.weather_data_class.Location

data class WeatherModel(
    var current: Current,
    var location: Location
)