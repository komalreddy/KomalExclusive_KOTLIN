package com.komala.komalexclusive_kotlin.model.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Request {
    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("query")
    @Expose
    var query: String? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("unit")
    @Expose
    var unit: String? = null
}