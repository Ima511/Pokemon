package com.present.pokemon.repository

import android.util.Log
import com.present.pokemon.data.DataOrException
import com.present.pokemon.model.PokemonDetails
import com.present.pokemon.model.Pokemons
import com.present.pokemon.network.PokemonApi
import retrofit2.Response
import javax.inject.Inject

class PokemonsRepository @Inject constructor(private val pokemonApi: PokemonApi) {
    // Extension function to parse error body
    private fun Response<*>.errorBodyAsString(): String? {
        return this.errorBody()?.string()
    }

    suspend fun getPokemons(): DataOrException<Pokemons, Boolean, Exception> {
        return try {
            val response = pokemonApi.getPokemons()
            if (response.isSuccessful) {
                DataOrException(data = response.body())
            } else {
                val errorMessage = response.errorBodyAsString()
                Log.d("Pokemon Error", "Error: ${response.code()}, Message: $errorMessage")
                DataOrException(data = null, e = Exception("Error: ${response.code()}, Message: $errorMessage"))
            }
        } catch (e: Exception) {
            Log.d("Exception while getting Pokemons", e.toString())
            DataOrException(e = e)
        }
    }

    suspend fun getPokemonsDetails(id: String): DataOrException<PokemonDetails, Boolean, Exception> {
        return try {
            val response = pokemonApi.getPokemonsDetail(id)
            if (response.isSuccessful) {
                DataOrException(data = response.body())
            } else {
                val errorMessage = response.errorBodyAsString()
                Log.d("Pokemon Details Error", "Error: ${response.code()}, Message: $errorMessage")
                DataOrException(data = null, e = Exception("Error: ${response.code()}, Message: $errorMessage"))
            }
        } catch (e: Exception) {
            Log.d("Exception while getting Pokemons Details", e.toString())
            DataOrException(e = e)
        }
    }

}