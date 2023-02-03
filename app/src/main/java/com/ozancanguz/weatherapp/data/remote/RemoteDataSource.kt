package com.ozancanguz.weatherapp.data.remote

import com.ozancanguz.weatherapp.data.models.Weather
import com.ozancanguz.weatherapp.data.network.WeatherApi
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val weatherApi: WeatherApi) {


    suspend fun getWeather(lang:String,city:String):Response<Weather>{
        return weatherApi.getWeather(lang,city)
    }


}