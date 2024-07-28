package com.present.pokemon.screens.pokemonDetail

import com.present.pokemon.model.PokemonDetails

data class PokemonDetailUiState(
    val pokemonDetails: PokemonDetails? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
