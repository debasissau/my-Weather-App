package com.example.myweatherapp

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.api.constant.Constant
import com.example.myweatherapp.api.RetrofitInstance
import com.example.myweatherapp.api.weather_data_class.WeatherModel
import com.example.myweatherapp.api.network.NetworkState
import kotlinx.coroutines.launch


class WeatherViewModel: ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkState<WeatherModel>>()
    val weatherResult : LiveData<NetworkState<WeatherModel>> = _weatherResult

    fun getData(city: String){
        _weatherResult.value = NetworkState.Loading
        viewModelScope.launch {

            try {
                val response = weatherApi.getWeather(Constant.apiKey, city)
                if(response.isSuccessful){
                    response.body()?.let { result->
                        _weatherResult.value= NetworkState.Success(result)
                    }
                }else{
                    _weatherResult.value= NetworkState.Error("Failed to load data")
                }
            }catch (e: Exception){
                _weatherResult.value = NetworkState.Error("Failed to load data")
            }
        }

    }
}