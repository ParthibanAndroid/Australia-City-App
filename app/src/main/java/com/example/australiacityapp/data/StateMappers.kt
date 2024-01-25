package com.example.australiacityapp.data

import com.example.australiacityapp.data.model.City
import com.example.australiacityapp.data.model.StateResponseItem

fun StateResponseItem.toCity() : City {
    return City(
        state = state,
        capital = capital,
        city = city,
        country = country,
        iso2 = iso2,
        lat = lat,
        lng = lng,
        population = population,
        populationProper = populationProper,
    )
}