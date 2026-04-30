package com.example.myweatherapp.api.network
// here T refers to WeatherModel
sealed class NetworkState<out T> {
    data class Success<out T> (val data:T) : NetworkState<T>()
    data class Error(val message: String): NetworkState<Nothing>()
    object Loading: NetworkState<Nothing>()
}