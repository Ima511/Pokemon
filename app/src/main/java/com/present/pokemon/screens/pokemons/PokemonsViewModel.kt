package com.present.pokemon.screens.pokemons

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
class PokemonsViewModel @Inject constructor(private val repository: PokemonsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(PokemonsUiState())
    val uiState: StateFlow<PokemonsUiState> = _uiState.asStateFlow()

    init {
        getPokemons()
    }

    private fun getPokemons() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            try {

                val result = repository.getPokemons()

                _uiState.value = _uiState.value.copy(
                    pokemons = result.data?.results ?: emptyList(),
                    isLoading = false,
                    error = result.e?.message
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}
