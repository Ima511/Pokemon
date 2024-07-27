package com.present.pokemon.screens.pokemons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.present.pokemon.model.Result


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonsScreen(
    navController: NavController? = null,
    uiState: PokemonsUiState
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pokémon List") }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when {
                uiState.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                uiState.error != null -> {
                    Text(
                        text = "Error: ${uiState.error}",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                uiState.pokemons.isNotEmpty() -> {
                    PokemonList(pokemons = uiState.pokemons)
                }
                else -> {
                    Text("No data available", modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun PokemonList(pokemons: List<Result>) {
    LazyColumn {
        items(pokemons) { pokemon ->
            PokemonItem(pokemon = pokemon)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Result) {
    Text(text = pokemon.name, style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewPokemonsScreen() {
    val samplePokemons = listOf(
        Result(name = "Bulbasaur"),
        Result(name = "Charmander"),
        Result(name = "Squirtle")
    )
    val sampleUiState = PokemonsUiState(pokemons = samplePokemons, isLoading = false, error = null)
    PokemonsScreen(uiState = sampleUiState)
}


