package com.example.australiacityapp.states

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.australiacityapp.data.model.StateList
import com.example.australiacityapp.data.repository.IStateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatesViewModel @Inject constructor(private val iStateRepository: IStateRepository) :
    ViewModel() {
    private var _states = MutableStateFlow<List<StateList>>(emptyList())
    val states = _states.asStateFlow()

    init {
        getStates()
    }

    private fun getStates() {
        viewModelScope.launch(Dispatchers.IO) {
            _states.value = iStateRepository.getStates()
        }
    }

    fun listInAscending() {
        val states = _states.value

        _states.value = states.sortedByDescending { it.state }
    }

    fun listInDescending() {
        val states = _states.value

        _states.value = states.sortedBy { it.state }
    }
}