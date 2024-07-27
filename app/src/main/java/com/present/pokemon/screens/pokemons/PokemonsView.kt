package com.present.pokemon.screens.pokemons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PokemonsView(navController: NavController, viewModel: PokemonsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    PokemonsScreen(navController = navController, uiState = uiState)
}