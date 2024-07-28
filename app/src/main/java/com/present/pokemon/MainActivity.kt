package com.present.pokemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.present.pokemon.screens.pokemonDetail.PokemonDetailsScreen
import com.present.pokemon.screens.pokemons.PokemonsScreen
import com.present.pokemon.screens.pokemons.PokemonsView
import com.present.pokemon.ui.theme.PokemonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "pokemons") {
                    composable("pokemons") {
                        PokemonsView(navController = navController)
                    }
                    composable(
                        "pokemonDetails/{pokemonId}",
                        arguments = listOf(navArgument("pokemonId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val pokemonId = backStackEntry.arguments?.getString("pokemonId")
                        PokemonDetailsScreen(pokemonId = pokemonId, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokemonTheme {
        Greeting("Android")
    }
}