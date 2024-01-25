package com.example.australiacityapp.states

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.australiacityapp.R
import com.example.australiacityapp.data.model.StateList
import com.example.australiacityapp.ui.theme.AustraliaCityAppTheme
import com.example.australiacityapp.util.Constants

@Composable
fun StatesScreen(
    modifier: Modifier = Modifier,
    statesViewModel: StatesViewModel = viewModel(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    val states = statesViewModel.states.collectAsState().value
    var isArrowUp by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (isArrowUp) {
                    isArrowUp = false
                    statesViewModel.listInDescending()
                } else {
                    isArrowUp = true
                    statesViewModel.listInAscending()
                }
            }) {
                Icon(
                    imageVector = if (isArrowUp) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (isArrowUp) stringResource(id = R.string.arrow_up) else stringResource(
                        id = R.string.arrow_down
                    )
                )
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            StateContent(states = states)
        }
    }
}

@Composable
fun StateContent(states: List<StateList> = Constants.stateList) {
    LazyColumn {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(states) { states ->
            StateItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(8.dp),
                        color = Color.Gray
                    ),
                state = states.state,
                cities = states.cities
            )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityListScreenLightPreview() {
    AustraliaCityAppTheme(darkTheme = false) {
        StatesScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun CityListScreenDarkPreview() {
    AustraliaCityAppTheme(darkTheme = true) {
        StatesScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun StateContentLightPreview() {
    AustraliaCityAppTheme(darkTheme = false) {
        StateContent()
    }
}

@Preview(showBackground = true)
@Composable
fun StateContentDarkPreview() {
    AustraliaCityAppTheme(darkTheme = true) {
        StateContent()
    }
}