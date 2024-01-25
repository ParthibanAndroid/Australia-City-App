package com.example.australiacityapp.data.source.local

import android.content.Context
import com.example.australiacityapp.R
import com.example.australiacityapp.data.model.StateList
import com.example.australiacityapp.data.model.StateResponse
import com.example.australiacityapp.data.toCity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StateLocalDataSourceImpl @Inject constructor(@ApplicationContext private val context: Context) :
    IStateLocalDataSource {

    override suspend fun getStates(): List<StateList> {
        val stateOfCities = arrayListOf<StateList>()

        val resourceId = R.raw.au_cities
        val inputStream = context.resources.openRawResource(resourceId)

        val rawString = inputStream.bufferedReader().use {
            it.readText()
        }
        val gson = Gson()
        val stateResponse =
            gson.fromJson<StateResponse>(
                rawString,
                object : TypeToken<StateResponse>() {}.type
            )
        val cities = stateResponse
            .map {
                it.toCity()
            }.sortedBy {
                it.state
            }

        cities.groupBy {
            it.state
        }.entries.forEach {
            val stateList = StateList(
                state = it.key,
                cities = it.value
            )
            stateOfCities.add(stateList)
        }

        inputStream.close()

        return stateOfCities
    }
}