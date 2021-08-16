package com.komala.komalexclusive_kotlin.model.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Current {
    @SerializedName("observation_time")
    @Expose
    var observationTime: String? = null

    @SerializedName("temperature")
    @Expose
    var temperature: Int? = null

    @SerializedName("weather_code")
    @Expose
    var weatherCode: Int? = null

    @SerializedName("weather_icons")
    @Expose
    var weatherIcons: List<String>? = null

    @SerializedName("weather_descriptions")
    @Expose
    var weatherDescriptions: List<String>? = null

    @SerializedName("wind_speed")
    @Expose
    var windSpeed: Int? = null

    @SerializedName("wind_degree")
    @Expose
    var windDegree: Int? = null

    @SerializedName("wind_dir")
    @Expose
    var windDir: String? = null

    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null

    @SerializedName("precip")
    @Expose
    var precip: Double? = null

    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null

    @SerializedName("cloudcover")
    @Expose
    var cloudcover: Int? = null

    @SerializedName("feelslike")
    @Expose
    var feelslike: Int? = null

    @SerializedName("uv_index")
    @Expose
    var uvIndex: Int? = null

    @SerializedName("visibility")
    @Expose
    var visibility: Int? = null

    @SerializedName("is_day")
    @Expose
    var isDay: String? = null
}