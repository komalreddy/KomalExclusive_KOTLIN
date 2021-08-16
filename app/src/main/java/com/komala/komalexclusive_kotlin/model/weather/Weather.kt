package com.komala.komalexclusive_kotlin.model.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Weather {
    @SerializedName("request")
    @Expose
    var request: Request? = null

    @SerializedName("location")
    @Expose
    var location: Location? = null

    @SerializedName("current")
    @Expose
    var current: Current? = null
}