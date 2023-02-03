package com.ozancanguz.weatherapp.data.network

import com.ozancanguz.weatherapp.data.models.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

    @Headers(
        "authorization: apikey 6XBClsiyFUwn61jEKgPcWy:7hBFCMRuNZto9F4nzaj3Mz",
        "content-type: application/json"
    )
    @GET("getWeather")
    suspend fun getWeather(@Query("data.lang") datalang:String,
                           @Query("data.city")city:String):Response<Weather>

}