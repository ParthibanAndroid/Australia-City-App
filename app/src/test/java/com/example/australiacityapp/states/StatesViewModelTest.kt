package com.example.australiacityapp.states

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.australiacityapp.data.repository.IStateRepository
import com.example.australiacityapp.data.repository.StateRepositoryImplTest
import com.example.australiacityapp.util.Constants
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class StatesViewModelTest {
    private lateinit var iStateRepository: IStateRepository
    private lateinit var statesViewModel: StatesViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        iStateRepository = StateRepositoryImplTest()
        statesViewModel = StatesViewModel(iStateRepository)
    }

    @Test
    fun getCities_returnsCitiesList() = runTest(StandardTestDispatcher()) {
        val expectedData = Constants.stateList
        val actualData = statesViewModel.states.value

        assertThat(actualData).isEqualTo(expectedData)
    }
}