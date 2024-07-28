package com.present.pokemon.screens.pokemons

import android.util.Log
import androidx.compose.foundation.clickable
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


/*@OptIn(ExperimentalMaterial3Api::class)
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
                    if (navController != null) {
                        PokemonList(pokemons = uiState.pokemons, navController = navController)
                    }
                }
                else -> {
                    Text("No data available", modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun PokemonList(pokemons: List<Result>, navController: NavController) {
    LazyColumn {
        items(pokemons) { pokemon ->
            PokemonItem(pokemon = pokemon, navController = navController)
        }
    }
}

*//*@Composable
fun PokemonItem(pokemon: Result) {
    Text(text = pokemon.name, style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp))
}*//*

@Composable
fun PokemonItem(pokemon: Result, navController: NavController) {
    Text(
        text = pokemon.name,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                Log.d("Url of pokemon", pokemon.url)
                navController.navigate("pokemonDetails/${pokemon.url.split("/").last()}")
            }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPokemonsScreen() {
    val samplePokemons = listOf(
        Result(name = "Bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
        Result(name = "Charmander", url = "https://pokeapi.co/api/v2/pokemon/4/"),
        Result(name = "Squirtle",  url = "https://pokeapi.co/api/v2/pokemon/7/")
    )
    val sampleUiState = PokemonsUiState(pokemons = samplePokemons, isLoading = false, error = null)
    PokemonsScreen(uiState = sampleUiState)
}*/

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
                    if (navController != null) {
                        PokemonList(pokemons = uiState.pokemons, navController = navController)
                    }
                }
                else -> {
                    Text("No data available", modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

@Composable
fun PokemonList(pokemons: List<Result>, navController: NavController) {
    LazyColumn {
        items(pokemons) { pokemon ->
            PokemonItem(pokemon = pokemon, navController = navController)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Result, navController: NavController) {
    Text(
        text = pokemon.name,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                Log.d("Url of pokemon", pokemon.url.split("/").toString())
                var urlList = pokemon.url.split("/")
                urlList.get(urlList.size-1)
                Log.d("Url of pokemon", urlList.get(urlList.size-2))
                navController.navigate("pokemonDetails/${ urlList.get(urlList.size-2)}")
            }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPokemonsScreen() {
    val samplePokemons = listOf(
        Result(name = "Bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
        Result(name = "Charmander", url = "https://pokeapi.co/api/v2/pokemon/4/"),
        Result(name = "Squirtle",  url = "https://pokeapi.co/api/v2/pokemon/7/")
    )
    val sampleUiState = PokemonsUiState(pokemons = samplePokemons, isLoading = false, error = null)
    PokemonsScreen(uiState = sampleUiState)
}
