package com.present.pokemon.screens.pokemonDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun PokemonDetailsView(
    navController: NavController,
    viewModel: PokemonDetailViewModel = hiltViewModel(),
    id: String
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = id) {
        viewModel.getPokemonDetails(id)
    }

    PokemonDetailsScreen(navController = navController, uiState = uiState)
}
