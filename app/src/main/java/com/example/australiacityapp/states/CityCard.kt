package com.example.australiacityapp.states

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.australiacityapp.data.model.City
import com.example.australiacityapp.ui.theme.AustraliaCityAppTheme
import com.example.australiacityapp.util.Constants

@Composable
fun CityCard(
    modifier: Modifier = Modifier,
    city: City = Constants.stateList[0].cities[0]
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = city.city,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "State : ${city.state}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Population : ${city.population}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityCardLightPreview() {
    AustraliaCityAppTheme(darkTheme = false) {
        CityCard()
    }
}

@Preview(showBackground = true)
@Composable
fun CityCardDarkPreview() {
    AustraliaCityAppTheme(darkTheme = true) {
        CityCard()
    }
}