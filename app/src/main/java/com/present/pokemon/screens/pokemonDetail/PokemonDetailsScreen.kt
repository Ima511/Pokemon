package com.present.pokemon.screens.pokemonDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PokemonDetailsScreen(pokemonId: String?, navController: NavController) {
    // Replace with actual Pokémon details fetching and displaying
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Pokémon Details for ID: $pokemonId", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPokemonDetailsScreen() {
    PokemonDetailsScreen(pokemonId = "1", navController = rememberNavController())
}