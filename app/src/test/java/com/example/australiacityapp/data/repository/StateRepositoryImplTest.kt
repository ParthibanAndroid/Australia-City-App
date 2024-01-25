package com.example.australiacityapp.data.repository

import com.example.australiacityapp.data.model.StateList
import com.example.australiacityapp.util.Constants

class StateRepositoryImplTest : IStateRepository {
    private var stateOfCities = listOf<StateList>()

    override suspend fun getStates(): List<StateList> {
        stateOfCities = Constants.stateList

        return stateOfCities
    }
}