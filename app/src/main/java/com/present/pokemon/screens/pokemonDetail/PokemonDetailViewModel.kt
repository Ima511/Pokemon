package com.present.pokemon.screens.pokemonDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.present.pokemon.repository.PokemonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val repository: PokemonsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(PokemonDetailUiState())
    val uiState: StateFlow<PokemonDetailUiState> = _uiState.asStateFlow()


    fun getPokemonDetails(id: String) {
        _uiState.value = PokemonDetailUiState(isLoading = true)
        viewModelScope.launch {
            try {
                val result = repository.getPokemonsDetails(id)
                _uiState.value = _uiState.value.copy(
                    pokemonDetails = result.data,
                    isLoading = false,
                    error = result.e?.message
                )
            } catch (e: Exception) {
                _uiState.value = PokemonDetailUiState(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}