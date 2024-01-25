package com.example.australiacityapp.data.repository

import com.example.australiacityapp.data.model.StateList
import com.example.australiacityapp.data.source.local.IStateLocalDataSource
import javax.inject.Inject

class StateRepositoryImpl @Inject constructor(private val iStateLocalDataSource: IStateLocalDataSource) : IStateRepository {

    override suspend fun getStates(): List<StateList> {
        return iStateLocalDataSource.getStates()
    }
}