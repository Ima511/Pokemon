package com.present.pokemon.screens.pokemons

import com.present.pokemon.model.Result

data class PokemonsUiState(
    val pokemons: List<Result> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)