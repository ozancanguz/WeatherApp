package com.ozancanguz.weatherapp.data.models


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("city")
    val city: String,
    @SerializedName("result")
    val result: List<WeatherResult>,
    @SerializedName("success")
    val success: Boolean
)