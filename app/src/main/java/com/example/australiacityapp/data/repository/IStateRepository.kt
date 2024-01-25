package com.example.australiacityapp.data.repository

import com.example.australiacityapp.data.model.StateList

interface IStateRepository {

    suspend fun getStates() : List<StateList>
}