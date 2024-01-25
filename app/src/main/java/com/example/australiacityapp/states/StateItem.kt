package com.example.australiacityapp.states

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.australiacityapp.R
import com.example.australiacityapp.data.model.City
import com.example.australiacityapp.ui.theme.AustraliaCityAppTheme
import com.example.australiacityapp.util.Constants

@Composable
fun StateItem(
    modifier: Modifier = Modifier,
    state: String = Constants.stateList[0].state,
    cities: List<City> = Constants.stateList[0].cities
) {
    var isShowCities by remember {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = state)
            IconButton(onClick = {
                isShowCities = !isShowCities
            }) {
                Icon(
                    imageVector = if (!isShowCities) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowUp,
                    contentDescription = if (!isShowCities) stringResource(id = R.string.arrow_down) else stringResource(
                        id = R.string.arrow_up
                    )
                )
            }
        }
        AnimatedVisibility(visible = isShowCities) {
            ExpandableCityList(cities = cities)
        }
    }
}

@Composable
fun ExpandableCityList(cities: List<City> = Constants.stateList[0].cities) {
    Column {
        for (city in cities) {
            CityCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    ),
                city = city
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun StateItemLightPreview() {
    AustraliaCityAppTheme(darkTheme = false) {
        StateItem()
    }
}

@Preview(showBackground = true)
@Composable
fun StateItemDarkPreview() {
    AustraliaCityAppTheme(darkTheme = true) {
        StateItem()
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCityListPreview() {
    AustraliaCityAppTheme(darkTheme = false) {
        ExpandableCityList()
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCityListDarkPreview() {
    AustraliaCityAppTheme(darkTheme = true) {
        ExpandableCityList()
    }
}