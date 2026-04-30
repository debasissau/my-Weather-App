package com.example.myweatherapp.api.weather_data_class

data class Location(
    var country: String,
    var lat: Double,
    var localtime: String,
    var localtime_epoch: Int,
    var lon: Double,
    var name: String,
    var region: String,
    var tz_id: String
)