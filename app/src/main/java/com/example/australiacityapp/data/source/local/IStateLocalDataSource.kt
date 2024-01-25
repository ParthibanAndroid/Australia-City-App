package com.example.australiacityapp.data.source.local

import com.example.australiacityapp.data.model.StateList

interface IStateLocalDataSource {

    suspend fun getStates() : List<StateList>
}