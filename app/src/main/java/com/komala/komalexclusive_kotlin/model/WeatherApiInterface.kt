package com.komala.komalexclusive_kotlin.model

import com.komala.komalexclusive_kotlin.model.weather.Weather
import com.komala.komalexclusive_kotlin.util.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiInterface {
    @GET("current")
    fun getWeatherByLocation(@Query("access_key") access_key: String, @Query("query") location: String): Call<Weather>

    companion object{
        var weatherApiInterface: WeatherApiInterface? = null

        fun getInstance():WeatherApiInterface{
            if (weatherApiInterface == null){
                var loggingInterceptor:HttpLoggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                val okHttpClient:OkHttpClient = OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()

                weatherApiInterface= Retrofit.Builder().baseUrl(Constant.Whether.URL_PREFIX_WEATHER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build().create(WeatherApiInterface::class.java)


            }
            return weatherApiInterface!!
        }

    }
}