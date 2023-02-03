package com.ozancanguz.weatherapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.weatherapp.data.models.Weather
import com.ozancanguz.weatherapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class WeatherViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {


    var weatherList=MutableLiveData<Weather>()

    fun getWeather(lang:String,city:String){
        viewModelScope.launch {
            val response=repository.remote.getWeather(lang,city)
            if(response.isSuccessful){
                weatherList.postValue(response.body())

            }else{
                Log.d("weatherviewmodel","No data")
            }
        }
    }



}