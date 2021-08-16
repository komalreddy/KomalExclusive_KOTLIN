package com.komala.komalexclusive_kotlin.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.komala.komalexclusive_kotlin.model.WeatherApiInterface
import com.komala.komalexclusive_kotlin.model.weather.Weather
import com.komala.komalexclusive_kotlin.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel : ViewModel() {

    private val successWeatherMutableLiveData = MutableLiveData<Weather>()
    private val failureWeatherMutableLiveData = MutableLiveData<String>()

    val successWeatherReport: LiveData<Weather> = successWeatherMutableLiveData
    val failureWeatherReport: LiveData<String> = failureWeatherMutableLiveData

    fun loadCurrentWeatherReport(location: String){

    WeatherApiInterface.getInstance().getWeatherByLocation(Constant.Whether.API_KEY_NEWS, location)
        .enqueue(object :Callback<Weather>{
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response != null && response.body() != null){
                    successWeatherMutableLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                failureWeatherMutableLiveData.postValue(t.localizedMessage)
            }

        })
    }
}