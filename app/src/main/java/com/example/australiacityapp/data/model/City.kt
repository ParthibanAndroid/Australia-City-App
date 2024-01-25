package com.example.australiacityapp.data.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("state")
    val state: String,
    @SerializedName("capital")
    val capital: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("iso2")
    val iso2: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String,
    @SerializedName("population")
    val population: String,
    @SerializedName("population_proper")
    val populationProper: String
)