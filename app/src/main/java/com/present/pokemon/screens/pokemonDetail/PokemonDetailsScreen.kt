package com.present.pokemon.screens.pokemonDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.present.pokemon.model.PokemonDetails

@Composable
fun PokemonDetailsScreen(
    navController: NavController,
    uiState: PokemonDetailUiState
) {
    if (uiState.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (uiState.error != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "Error: ${uiState.error}",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleLarge
            )
        }
    } else if (uiState.pokemonDetails != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${uiState.pokemonDetails.id}.png",
                contentDescription = "Image of ${uiState.pokemonDetails.name}",
                modifier = Modifier
                    .size(128.dp)
                    .padding(bottom = 16.dp)
            )

                Text(
                text = "Name: ${uiState.pokemonDetails.name}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Height: ${uiState.pokemonDetails.height}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Weight: ${uiState.pokemonDetails.weight}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Base Experience: ${uiState.pokemonDetails.baseExperience}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Add more details as needed
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPokemonDetailsScreen() {
    val uiState = PokemonDetailUiState(PokemonDetails(name = "Pikachu",id = 25, height = 4, weight = 6, baseExperience = 112))
    val navController = rememberNavController()

    PokemonDetailsScreen(uiState = uiState, navController = navController)
}