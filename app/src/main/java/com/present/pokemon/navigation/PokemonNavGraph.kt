package com.present.pokemon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.present.pokemon.screens.pokemonDetail.PokemonDetailsView
import com.present.pokemon.screens.pokemons.PokemonsView

@Composable
fun PokemonNavGraph(startDestination: String = "pokemons", navController: NavHostController) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("pokemons") { backStackEntry ->
            PokemonsView(navController = navController)

        }
        /*composable("pokemonDetails/{id}") { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("id")
            if (pokemonId != null) {
                PokemonDetailsView(navController = navController)
            }
        }*/
        composable("pokemonDetails/{id}") { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("id")
/*
            val viewModel: PokemonDetailViewModel = hiltViewModel()
*/
            if (pokemonId != null) {
                /*viewModel.getPokemonDetails(pokemonId)
                val uiState by viewModel.uiState.collectAsState()
                PokemonDetailsScreen(navController = navController,uiState = uiState)*/
                PokemonDetailsView(navController = navController, id = pokemonId)
            }
        }
    }
}
