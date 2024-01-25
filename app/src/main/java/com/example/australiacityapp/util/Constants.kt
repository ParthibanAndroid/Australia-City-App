package com.example.australiacityapp.util

import com.example.australiacityapp.data.model.City
import com.example.australiacityapp.data.model.StateList

object Constants {
    const val StopTimeoutMillis: Long = 5000

    val stateList = listOf(
        StateList(
            state = "New South Wales",
            cities = listOf(
                City(
                    city = "Sydney",
                    lat = "-33.8678",
                    lng = "151.2100",
                    country = "Australia",
                    iso2 = "AU",
                    state = "New South Wales",
                    capital = "admin",
                    population = "4840600",
                    populationProper = "4840600",
                )
            )
        ),
        StateList(
            state = "Victoria",
            cities = listOf(
                City(
                    city = "Melbourne",
                    lat = "-37.8142",
                    lng = "144.9631",
                    country = "Australia",
                    iso2 = "AU",
                    state = "Victoria",
                    capital = "admin",
                    population = "4529500",
                    populationProper = "4529500",
                )
            )
        ),
        StateList(
            state = "Queensland",
            cities = listOf(
                City(
                    city = "Brisbane",
                    lat = "-27.4678",
                    lng = "153.0281",
                    country = "Australia",
                    iso2 = "AU",
                    state = "Queensland",
                    capital = "admin",
                    population = "2360241",
                    populationProper = "2360241",
                )
            )
        )
    )
}